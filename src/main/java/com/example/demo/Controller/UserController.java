package com.example.demo.Controller;


import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
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


    @GetMapping("/admin")
    public UserDTO registerUser(){
        return userService.registerUser();

    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute User user, Model model){
        model.addAttribute("activePage", "login");
        userService.register(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }


    @GetMapping("/home")
    public String temp(){
        return "Hello";
    }
    @GetMapping("/user/home")
    public String temp2(){
        return "Hello";
    }




    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }








    //    @GetMapping("/update/{id}")
//    public User updateUserById(@PathVariable Long id, @RequestBody User user){
//        return userService.updateUserById(id, user);
//    }

//    @GetMapping("/all")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/byId/{id}")
//    public User getUserByID(@PathVariable Long id) {
//        return userService.getUserByID(id);
//    }
//
//    @GetMapping("/delete/{id}")
//    public boolean deleteByID(@PathVariable Long id) {
//        return userService.deleteByID(id);
//    }
//
//    @GetMapping("/dayBetween/from/{startYear}/{startMonth}/{startDay}/to/{endYear}/{endMonth}/{endDay}")
//    public List<User> getUserWithDateBefore(@PathVariable int startYear,
//                                            @PathVariable int startMonth,
//                                            @PathVariable int startDay,
//                                            @PathVariable int endYear,
//                                            @PathVariable int endMonth,
//                                            @PathVariable int endDay) {
//        return userService.allUserWithBirthDay(LocalDate.of(startYear, startMonth, startDay),
//                LocalDate.of(endYear, endMonth, endDay));
//    }


}
