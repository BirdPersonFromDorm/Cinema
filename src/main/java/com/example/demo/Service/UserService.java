package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Builder
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDTO userDTO;
    @Autowired
    private PasswordEncoder encoder;


    public User addUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public UserDTO getUserBuID(int id){
        Optional<User> byId = userRepository.findById(id);
        return userDTO.mapToDTO(byId.get());
    }

    public UserDTO addUserByRoleUser(User user){
        Role getUserRole = roleRepository.getById(1);
        Set<Role> roles = new HashSet<>();
        roles.add(getUserRole);
        user.setRoles(roles);
        User save = userRepository.save(user);


        return userDTO.mapToDTO(save);
    }


    public User getAllIngo(int id){
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseGet(User::new);
    }

    public UserDTO registerUser(){
        Role getUserRole = roleRepository.getById(2);
        User user = new User();

        user.setLogin("admin");
        user.setPassword("admin");

        String encodePwd = encoder.encode(user.getPassword());
        user.setPassword(encodePwd);
        user.setRoles(Set.of(getUserRole));

        User save = userRepository.save(user);

        return userDTO.mapToDTO(save);
    }


    public void register(User user){

        String encodePwd = encoder.encode(user.getPassword());

        user.setPassword(encodePwd);

        Role getUserRole = roleRepository.getById(1);
        user.setRoles(Set.of(getUserRole));

        User userFromDB = userRepository.save(user);

    }

    public User getAllTicketsByUser(String login){
        return userRepository.findByLogin(login);
    }





//    public User updateUserById(Long id, User user){
//        Optional<User> byId = userRepository.findById(id);
//        if(byId.isPresent()){
//            userRepository.updateById(id,user);
//        }
//        return byId.get();
//    }
//    public User foo(Session session){
//        User user = userRepository.getUserBySession(session);
//        return user;
//    }

    public List<UserDTO> getAllUsers(){
        List<User> all = userRepository.findAll();
        List<UserDTO> userDTOToShow = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            userDTOToShow.add(userDTO.mapToDTO(all.get(i)));
        }
        return userDTOToShow;
    }

//    public boolean addUser(User user){
//        DataBase.users.add(user);
//        return true;
//    }
//    public List<User> getAllUsers(){
//        return DataBase.users;
//    }
//
//    public User getUserByID(Long id){
//        User find = null;
//        for (int i = 0; i < DataBase.users.size(); i++) {
//            if (DataBase.users.get(i).getId() == id){
//                find = DataBase.users.get(i);
//            }
//        }
//        return find;
//    }
//    public boolean deleteByID(Long id) {
//        for (int i = 0; i < DataBase.users.size(); i++) {
//            if (DataBase.users.get(i).getId() == id) {
//                DataBase.users.remove(i);
//            }
//        }
//        return true;
//    }
//    public List<User> allUserWithBirthDay(LocalDate start, LocalDate end){
//        List<User> listOfUsers = new ArrayList<>();
//        for (int i = 0; i < DataBase.users.size(); i++) {
//            LocalDate ourDate = DataBase.users.get(i).getBirthday();
//            if(ourDate.isBefore(end) && ourDate.isAfter(start)){
//                listOfUsers.add(DataBase.users.get(i));
//            }
//        }
//
//        return listOfUsers;
//    }

}
