package com.example.demo.Controller;

import com.example.demo.DTO.SessionDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.Session;
import com.example.demo.Model.User;
import com.example.demo.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

//@RestController
@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/add")
    public Session addSession(@RequestBody Session session) {
        return sessionService.add(session);
    }

    @GetMapping("/delete/{id}")
    public void deleteSessionById(@PathVariable int id){
        sessionService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public SessionDTO getSessionByID(@PathVariable int id){
        return sessionService.getById(id);
    }

    @GetMapping("/getTodaySession")
    public List<SessionDTO> getTodaySession(){
        return sessionService.getTodaySession();
    }

    @GetMapping("/getSessionByDay/{date}")
    public List<SessionDTO> getSessionByDay(@PathVariable String date){
        return sessionService.getSessionByDay(date);
    }

    @PostMapping("/addSessionWithMovie/{id}")
    public SessionDTO addSessionWithMovie(@RequestBody Session session, @PathVariable int id) {
         return sessionService.addMovieToSession(session, id);
    }
    @GetMapping("getAllUsersInSession/{id}")
    public List<UserDTO> getSessionByDay(@PathVariable int id){
        return sessionService.getAllUsersInSession(id);
    }

    @PostMapping("/addNewSession")
    public ModelAndView addNewMovie(@ModelAttribute Session session, Model model){
        model.addAttribute("activePage", "admin");
        sessionService.add(session);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }



}
