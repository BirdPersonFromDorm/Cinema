package com.example.demo.repository;

import com.example.demo.Model.Session;
import com.example.demo.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
