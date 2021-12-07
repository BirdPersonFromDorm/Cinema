package com.example.demo.DTO;

import com.example.demo.Model.Movie;
import com.example.demo.Model.News;
import com.example.demo.Model.Session;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {

    private String newsTitle;
    private String newsMainDiscription;
    private String newsSecondDiscription;
    private String newsImg;

    public NewsDTO mapToDTO(News news) {
        NewsDTO newsDTOResponse = new NewsDTO();
        newsDTOResponse.setNewsTitle(news.getTitle());
        newsDTOResponse.setNewsMainDiscription(news.getMainDiscription());
        newsDTOResponse.setNewsSecondDiscription(news.getSecondDiscription());
        newsDTOResponse.setNewsImg(news.getImg());
        return newsDTOResponse;
    }
}
