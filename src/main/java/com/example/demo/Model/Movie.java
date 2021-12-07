package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Table(name = "movie")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "name")
    private String name;
    @Column(name = "discription")
    private String discription;
    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "movie", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("movie")
    private Set<Session> sessions;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
