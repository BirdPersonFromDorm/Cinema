package com.example.demo.Service;

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


//    public List<SessionDTOResponse> getCountFilmsToday() {
//        List<Session> all = sessionRepository.findAll();
//        List<String> nameOfFilm= new ArrayList<>();
//
//        List<SessionDTOResponse> collect = all.stream()
//                .filter(x -> x.getDate().equals(LocalDate.now()))
//                .map(x -> sessionDTOResponse.mapToDTO(x))
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < collect.size(); i++) {
//            nameOfFilm.add(collect.get(i).getMovieName())
//        }
//
//        return collect;
//    }


    public Session getAllIngo(int id) {
        Optional<Session> byId = sessionRepository.findById(id);
        return byId.orElseGet(Session::new);
    }




}
