package com.example.demo.DTO;

import com.example.demo.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String login;
    private String role;

    public UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        try{
            userDTO.setRole(user.getRoles().iterator().next().getRole().name());
        }catch (Exception e){
            e.getStackTrace();
        }

        return userDTO;
    }
}
