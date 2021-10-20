package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/films")
    public String getInfo(Model model){
        model.addAttribute("activePage", "films");
        return "films";
    }

    @GetMapping("/about")
    public String getContact(Model model){
        model.addAttribute("activePage", "about");
        return "about";
    }
    @GetMapping("/login")
    public String get(Model model) {
        model.addAttribute("title", "login");
        return "login";
    }

}