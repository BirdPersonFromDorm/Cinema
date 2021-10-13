package com.example.demo.DTO;


import com.example.demo.Model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private String user;
    private LocalDateTime date;
    private Double price;
    private String movieName;
    private String movieDiscription;

    public TicketDTO mapToDTOT(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setUser(ticket.getUser().getLogin());
        ticketDTO.setDate(ticket.getSession().getDate());
        ticketDTO.setPrice(ticket.getSession().getPrice());
        try{
            ticketDTO.setMovieName(ticket.getSession().getMovie().getName());
            ticketDTO.setMovieDiscription(ticket.getSession().getMovie().getDiscription());
        }catch (Exception e){
            e.getStackTrace();
        }
        return ticketDTO;
    }
}
