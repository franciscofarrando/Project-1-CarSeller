package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Role;
import com.example.CarSeller.models.Vendor;
import com.example.CarSeller.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/private")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }


    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable int id) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role ID not found"));

        roleRepository.delete(existingRole);
    }

    @PutMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Role updateRole(@PathVariable int id, @RequestBody Role role){
        Role existingRole = roleRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Role ID not found"));

        existingRole.setName(role.getName());

        return roleRepository.save(existingRole);
    }
}
