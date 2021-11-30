package com.example.demo.Controller;



import com.example.demo.DTO.TicketDTO;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.add(ticket);
    }

    @GetMapping("/delete/{id}")
    public void deleteTicketById(@PathVariable int id) {
        ticketService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public TicketDTO getTicketByID(@PathVariable int id) {
        return ticketService.getById(id);
    }

    @GetMapping("/addTicketByUserId/{userID}/{SessionId}")
    public TicketDTO add(@RequestBody Ticket ticket, @PathVariable int userID, @PathVariable int SessionId) {
        return ticketService.addTicketByUserId(ticket,userID,SessionId);
    }

    @GetMapping("/getAll/{id}")
    public Ticket getAllInfo(@PathVariable int id) {
        return ticketService.getAllIngo(id);
    }

    @PostMapping("/addNewTicketToUser")
    public ModelAndView addNewTicketToUser(@ModelAttribute Ticket ticket, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userService.getUserByLogin(name);

        ticketService.addNewTicketToUser(ticket, user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/account");
        return modelAndView;
    }
}
