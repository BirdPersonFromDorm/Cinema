package com.example.demo.Service;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.DTO.SessionDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Model.Session;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SessionDTO sessionDTOResponse;

    @Autowired
    private UserDTO userDTO;

    public Session add(Session session) {
        Session save = sessionRepository.save(session);
        return save;
    }

    public void deleteById(int id) {
        sessionRepository.deleteById(id);
    }

    public SessionDTO getById(int id) {
        Optional<Session> byId = sessionRepository.findById(id);
        return sessionDTOResponse.mapToDTO(byId.get());
    }

    public List<SessionDTO> getTodaySession() {
        List<Session> all = sessionRepository.findAll();


        return all.stream()
                .filter(x -> x.getDate().toLocalDate().equals(LocalDate.now()))
                .filter(x -> Objects.nonNull(x.getMovie()))
                .map(x -> sessionDTOResponse.mapToDTO(x))
                .collect(Collectors.toList());
    }

    public List<SessionDTO> getTomorrowSession() {
        List<Session> all = sessionRepository.findAll();
        LocalDate now = LocalDate.now().plusDays(1);

        return all.stream()
                .filter(x -> x.getDate().toLocalDate().equals(now))
                .filter(x -> Objects.nonNull(x.getMovie()))
                .map(x -> sessionDTOResponse.mapToDTO(x))
                .collect(Collectors.toList());
    }

    public List<SessionDTO> getDayAfterTomorrowSessions() {
        List<Session> all = sessionRepository.findAll();
        LocalDate now = LocalDate.now().plusDays(2);

        return all.stream()
                .filter(x -> x.getDate().toLocalDate().equals(now))
                .filter(x -> Objects.nonNull(x.getMovie()))
                .map(x -> sessionDTOResponse.mapToDTO(x))
                .collect(Collectors.toList());
    }

    public List<SessionDTO> getSessionsFromTodayToDayAfterTomorrow() {
        List<Session> all = sessionRepository.findAll();
        List<LocalDate> listOfDays = new ArrayList<>();
        listOfDays.add(LocalDate.now());
        listOfDays.add(LocalDate.now().plusDays(1));
        listOfDays.add(LocalDate.now().plusDays(2));

        return all.stream()
                .filter(x -> x.getDate().toLocalDate().equals(listOfDays.get(0)) || x.getDate().toLocalDate().equals(listOfDays.get(1)) || x.getDate().toLocalDate().equals(listOfDays.get(2)) )
                .filter(x -> Objects.nonNull(x.getMovie()))
                .map(x -> sessionDTOResponse.mapToDTO(x))
                .collect(Collectors.toList());
    }

    public List<SessionDTO> getSessionByDay(String date) {
        List<Session> all = sessionRepository.findAll();
        LocalDate localDate = LocalDate.parse(date);

        return all.stream()
                .filter(x -> x.getDate().toLocalDate().equals(localDate))
                .filter(x -> Objects.nonNull(x.getMovie()))
                .map(x -> sessionDTOResponse.mapToDTO(x))
                .collect(Collectors.toList());
    }

    public SessionDTO addMovieToSession(Session session, int id) {
        Movie byId = movieRepository.getById(id);
        session.setMovie(byId);
        Session save = sessionRepository.save(session);

        return sessionDTOResponse.mapToDTO(save);
    }

    public List<UserDTO> getAllUsersInSession(int id) {
        Session byId = sessionRepository.getById(id);
        List<UserDTO> collect = byId.getTickets()
                .stream()
                .map(x -> userDTO.mapToDTO(x.getUser()))
                .collect(Collectors.toList());

        return collect;
    }

    public List<SessionDTO> getAllSession(){
        List<Session> all = sessionRepository.findAll();
        List<SessionDTO> sessionDTOToShow = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            sessionDTOToShow.add(sessionDTOResponse.mapToDTO(all.get(i)));
        }
        return sessionDTOToShow;
    }




}
