package com.example.demo.Service;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Model.Session;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private MovieDTO movieDTO;

    public MovieDTO add(Movie movie){
        Movie save = movieRepository.save(movie);
        return movieDTO.mapToDTO(save);
    }
    public void deleteById(int id){
        movieRepository.deleteById(id);
    }

    public MovieDTO getById(int id){
        Optional<Movie> byId = movieRepository.findById(id);
        return movieDTO.mapToDTO(byId.get());
    }

    public Movie getAllIngo(int id){
        Optional<Movie> byId = movieRepository.findById(id);
        return byId.orElseGet(Movie::new);
    }

}
