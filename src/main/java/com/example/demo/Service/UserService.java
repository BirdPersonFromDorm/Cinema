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

    public User getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public List<UserDTO> getAllUsers(){
        List<User> all = userRepository.findAll();
        List<UserDTO> userDTOToShow = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            userDTOToShow.add(userDTO.mapToDTO(all.get(i)));
        }
        return userDTOToShow;
    }

}
