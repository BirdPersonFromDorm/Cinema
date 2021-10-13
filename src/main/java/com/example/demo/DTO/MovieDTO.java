package com.example.demo.DTO;


import com.example.demo.Model.Movie;
import com.example.demo.Model.Session;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {


    private String movieName;
    private String movieDiscription;
    @JsonIgnoreProperties("tickets")
    private Set<Session> sessions;

    public MovieDTO mapToDTO(Movie movie) {
        MovieDTO movieDTOResponse = new MovieDTO();
        movieDTOResponse.setMovieName(movie.getName());
        movieDTOResponse.setMovieDiscription(movie.getDiscription());
        movieDTOResponse.setSessions(movie.getSessions());
        return movieDTOResponse;
    }
}
