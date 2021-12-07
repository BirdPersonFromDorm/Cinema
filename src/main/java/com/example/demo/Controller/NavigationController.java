package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.NewsSercive;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class NavigationController {

    private static final String returAboutHTML = "about";
    private static final String returLogintHTML = "login";
    private static final String returRegistrationtHTML = "registration";
    private static final String returAdmintHTML = "admin";
    private static final String returMovietHTML = "movie";
    private static final String returIndextHTML = "index";

    @Autowired
    private NewsSercive newsSercive;

    @GetMapping("/about")
    public String getContact(Model model){
        model.addAttribute("activePage", "about");
        return returAboutHTML;
    }

    @GetMapping("/login")
    public String getlogin(Model model) {
        model.addAttribute("title", "login");
        return returLogintHTML;
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("user", new User());
        return returRegistrationtHTML;
    }

    @GetMapping("/addNewMovies")
    public String addNewMovies(Model model) {
        model.addAttribute("movie", new Movie());
        return returAdmintHTML;
    }

    @GetMapping("/addNewSession")
    public String addNewSession(Model model) {
        model.addAttribute("session", new Session());
        return returAdmintHTML;
    }

    @GetMapping("/addNewNews")
    public String addNewNEws(Model model) {
        model.addAttribute("news", new News());
        return returAdmintHTML;
    }

    @GetMapping("/addNewTicketToUser")
    public String addNewTicketToUser(Model model) {
        model.addAttribute("ticketForAdd", new Ticket());
        return returMovietHTML;
    }

    @RequestMapping(value = "/")
    public String homepage(Model model) {
        model.addAttribute("allNews", newsSercive.getAllNews());
        return returIndextHTML;
    }


}