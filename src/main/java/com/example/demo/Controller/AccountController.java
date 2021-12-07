package com.example.demo.Controller;


import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import com.example.demo.Service.SessionService;
import com.example.demo.Service.TicketService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/account")
public class AccountController {

    private static final String returAccountHTML = "account";

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("")
    public String getAllTickets(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User allTicketsByUser = userService.getUserByLogin(name);
        Set<Ticket> tickets = allTicketsByUser.getTickets();

        model.addAttribute("tickets", tickets);
        model.addAttribute("allSessionForAccount", sessionService.getSessionsFromTodayToDayAfterTomorrow());

        return returAccountHTML;
    }
}
