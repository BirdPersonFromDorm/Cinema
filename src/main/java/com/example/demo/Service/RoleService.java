package com.example.demo.Service;

import com.example.demo.DTO.RoleDTO;
import com.example.demo.Model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleDTO roleDTO;

    public Role add(Role role){
        Role save = roleRepository.save(role);
        return save;
    }
    public void deleteById(int id){
        roleRepository.deleteById(id);
    }

    public RoleDTO getById(int id){
        Optional<Role> byId = roleRepository.findById(id);
        return roleDTO.mapToDTOT(byId.get());
    }
}
