package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Model.Session;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private NewsSercive newsSercive;

    @Autowired
    private TicketService ticketService;

    @GetMapping("")
    public String getAllUsers(Model model){
        model.addAttribute("activePage", "admin");
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("movie", movieService.getAllMovie());
        model.addAttribute("todaySessions", sessionService.getTodaySession());
        model.addAttribute("tomorrowSessions", sessionService.getTomorrowSession());
        model.addAttribute("allNews", newsSercive.getAllNews());
        model.addAttribute("countOfMovie", ticketService.getCountOfMovie());
        return "admin";
    }

}
