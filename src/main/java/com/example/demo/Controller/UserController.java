package com.example.demo.Controller;


import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/user")
@Builder
public class UserController {


    @Autowired
    private UserService userService;

//    @PostMapping("/add")
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }

    @GetMapping("/delete/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }

    @GetMapping("/get/{id}")
    public UserDTO getUserByID(@PathVariable int id){
        return userService.getUserBuID(id);
    }

    @GetMapping("/getAll/{id}")
    public User getAllInfo(@PathVariable int id){
        return userService.getAllIngo(id);
    }

    @PostMapping("/add")
    public UserDTO addUser(@RequestBody User user){
         return userService.addUserByRoleUser(user);
    }


    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute User user, Model model){
        model.addAttribute("activePage", "login");
        userService.register(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }



}
