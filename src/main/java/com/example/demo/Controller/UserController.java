package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String returRegistrationHTML = "redirect:/registration";

    @Autowired
    private UserService userService;

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
    public String registration(@ModelAttribute User user, Model model){
        User userByLogin = userService.getUserByLogin(user.getLogin());

        if (userByLogin != null){
            model.addAttribute("serverTime", "text");

        } else{
            userService.register(user);
        }

        return returRegistrationHTML;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

}
