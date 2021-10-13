package com.example.demo.Service;



import com.example.demo.DTO.TicketDTO;
import com.example.demo.Model.Session;
import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import com.example.demo.repository.SessionRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TicketDTO ticketDTO;



    public Ticket add(Ticket ticket){
        Ticket save = ticketRepository.save(ticket);
        return save;
    }
    public void deleteById(int id){
        ticketRepository.deleteById(id);
    }

    public TicketDTO getById(int id){
        Optional<Ticket> byId = ticketRepository.findById(id);
        return ticketDTO.mapToDTOT(byId.get());
    }

    public Ticket getAllIngo(int id){
        Optional<Ticket> byId = ticketRepository.findById(id);
        return byId.orElseGet(Ticket::new);
    }


    public TicketDTO addTicketByUserId(Ticket ticket, int userID, int SessionID) {
        User userByID = userRepository.getById(userID);
        Session sessionDyID = sessionRepository.getById(SessionID);
        ticket.setUser(userByID);
        ticket.setSession(sessionDyID);
        Ticket save = ticketRepository.save(ticket);
        return ticketDTO.mapToDTOT(save);
    }
}
