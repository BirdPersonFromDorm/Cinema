package com.example.demo.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "news")
@Entity
@Getter
@Setter
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Integer newsId;
    @Column(name = "title")
    private String title;
    @Column(name = "first_discription")
    private String mainDiscription;
    @Column(name = "second_discription")
    private String secondDiscription;
    @Column(name = "img")
    private String img;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        return newsId != null ? newsId.equals(news.newsId) : news.newsId == null;
    }

    @Override
    public int hashCode() {
        return newsId != null ? newsId.hashCode() : 0;
    }
}
