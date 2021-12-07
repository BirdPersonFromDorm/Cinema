package com.example.demo.Service;


import com.example.demo.DTO.MovieDTO;
import com.example.demo.DTO.NewsDTO;
import com.example.demo.Model.Movie;
import com.example.demo.Model.News;
import com.example.demo.Model.Session;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsSercive {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsDTO newsDTO;

    public List<NewsDTO> getAllNews(){
        List<News> all = newsRepository.findAll();
        List<NewsDTO> newsDTOToShow = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            newsDTOToShow.add(newsDTO.mapToDTO(all.get(i)));
        }
        return newsDTOToShow;
    }

    public void addNews(News news) {
        newsRepository.save(news);
    }

}
