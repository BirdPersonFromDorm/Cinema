package com.example.demo.Service;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Model.Session;
import com.example.demo.Model.User;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

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


    public List<MovieDTO> getAllMovie(){
        List<Movie> all = movieRepository.findAll();
        List<MovieDTO> movieDTOToShow = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            movieDTOToShow.add(movieDTO.mapToDTO(all.get(i)));
        }
        return movieDTOToShow;
    }
    


}
