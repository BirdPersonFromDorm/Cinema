package com.example.demo.repository;

import com.example.demo.Model.Role;
import com.example.demo.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {

}
