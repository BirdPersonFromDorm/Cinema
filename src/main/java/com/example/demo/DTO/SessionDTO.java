package com.example.demo.DTO;


import com.example.demo.Model.Session;
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
public class SessionDTO {

    private LocalDateTime date;
    private Double price;
    private String movieName;
    private String movieDiscription;

    public SessionDTO mapToDTO(Session session) {
        SessionDTO sessionDTOResponse = new SessionDTO();
        sessionDTOResponse.setDate(session.getDate());
        sessionDTOResponse.setPrice(session.getPrice());
        sessionDTOResponse.setMovieName(session.getMovie().getName());
        sessionDTOResponse.setMovieDiscription(session.getMovie().getDiscription());
        return sessionDTOResponse;
    }

}
