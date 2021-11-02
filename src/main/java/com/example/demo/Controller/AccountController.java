package com.example.demo.Controller;


import com.example.demo.Model.Movie;
import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import com.example.demo.Service.TicketService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;


    @GetMapping("")
    public String getAllTickets(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User allTicketsByUser = userService.getAllTicketsByUser(name);
        Set<Ticket> tickets = allTicketsByUser.getTickets();

        model.addAttribute("tickets", tickets);

        return "account";
    }

}
