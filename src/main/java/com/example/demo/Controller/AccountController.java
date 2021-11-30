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

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

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

        return "account";
    }

//    @PostMapping("/addNewTicketToUser")
//    public ModelAndView addNewTicketToUser(@ModelAttribute Ticket ticket, Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String name = authentication.getName();
//        User user = userService.getUserByLogin(name);
//
//        ticketService.addNewTicketToUser(ticket, user);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/account");
//        return modelAndView;
//    }


}
