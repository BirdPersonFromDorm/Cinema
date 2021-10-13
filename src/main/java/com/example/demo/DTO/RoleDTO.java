package com.example.demo.DTO;

import com.example.demo.Model.Role;
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
public class RoleDTO {

    private Role.Roles roleName;

    public RoleDTO mapToDTOT(Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName(role.getRole());
        return roleDTO;
    }
}
