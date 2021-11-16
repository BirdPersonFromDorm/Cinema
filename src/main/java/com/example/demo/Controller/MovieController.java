package com.example.demo.Controller;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Model.User;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.SessionService;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SessionService sessionService;

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

    @GetMapping("/all")
    public List<MovieDTO> getAllUsers(){
        return movieService.getAllMovie();
    }

    @GetMapping("")
    public String getInfo(Model model){
        model.addAttribute("activePage", "movie");
        model.addAttribute("movie", movieService.getAllMovie());
        model.addAttribute("todaySessions", sessionService.getTodaySession());
        return "movie";
    }

    @PostMapping("/addNewMovie")
    public ModelAndView addNewMovie(@ModelAttribute Movie movie, Model model){
        model.addAttribute("activePage", "admin");
        movieService.addNewMovie(movie);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }


}
