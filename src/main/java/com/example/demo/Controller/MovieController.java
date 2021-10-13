package com.example.demo.Controller;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public MovieDTO addMovie(@RequestBody Movie movie) {
        return movieService.add(movie);
    }

    @GetMapping("/delete/{id}")
    public void deleteMovieById(@PathVariable int id){
        movieService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public MovieDTO getMovieByID(@PathVariable int id){
        return movieService.getById(id);
    }


    @GetMapping("/getAll/{id}")
    public Movie getAllInfo(@PathVariable int id){
        return movieService.getAllIngo(id);
    }

}
