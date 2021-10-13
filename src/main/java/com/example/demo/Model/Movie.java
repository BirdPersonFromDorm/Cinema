package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "movie")
@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "name")
    private String name;
    @Column(name = "discription")
    private String discription;

    @OneToMany(mappedBy = "movie", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("movie")
    private Set<Session> sessions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return movieId != null ? movieId.equals(movie.movieId) : movie.movieId == null;
    }

    @Override
    public int hashCode() {
        return movieId != null ? movieId.hashCode() : 0;
    }
}
