package com.example.demo.Controller;


import com.example.demo.DTO.RoleDTO;
import com.example.demo.Model.Role;
import com.example.demo.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Role addRole(@RequestBody Role role) {
        return roleService.add(role);
    }

    @GetMapping("/delete/{id}")
    public void deleteRoleById(@PathVariable int id){
        roleService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public RoleDTO getRoleByID(@PathVariable int id){
        return roleService.getById(id);
    }
}
