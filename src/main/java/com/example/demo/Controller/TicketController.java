package com.example.demo.Controller;



import com.example.demo.DTO.TicketDTO;
import com.example.demo.Model.Ticket;
import com.example.demo.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

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
}
