package com.example.demo.repository;

import com.example.demo.Model.Movie;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
