package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

    @GetMapping("/about")
    public String getContact(Model model){
        model.addAttribute("activePage", "about");
        return "about";
    }
    @GetMapping("/login")
    public String getlogin(Model model) {
        model.addAttribute("title", "login");
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model) {
        model.addAttribute("activePage", "admin");
        return "admin";
    }


}