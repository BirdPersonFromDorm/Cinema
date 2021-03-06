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
    private int sessionId;
    private Double price;
    private String movieName;
    private String movieDiscription;
    private String movieImg;

    public SessionDTO mapToDTO(Session session) {
        SessionDTO sessionDTOResponse = new SessionDTO();
        sessionDTOResponse.setSessionId(session.getSessionId());
        sessionDTOResponse.setDate(session.getDate());
        sessionDTOResponse.setPrice(session.getPrice());
        sessionDTOResponse.setMovieName(session.getMovie().getName());
        sessionDTOResponse.setMovieDiscription(session.getMovie().getDiscription());
        sessionDTOResponse.setMovieImg(session.getMovie().getImg());
        return sessionDTOResponse;
    }

}
