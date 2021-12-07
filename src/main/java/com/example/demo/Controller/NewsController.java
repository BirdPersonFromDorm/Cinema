package com.example.demo.Controller;


import com.example.demo.Model.News;
import com.example.demo.Service.NewsSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final String returAdmintHTML = "redirect:/admin";

    @Autowired
    private NewsSercive newsSercive;

    @PostMapping("/addNewNews")
    public String addNewMovie(@ModelAttribute News news){
        newsSercive.addNews(news);
        return returAdmintHTML;
    }
}
