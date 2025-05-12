package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Manager;
import com.example.CarSeller.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Manager> getManagerById(@PathVariable(name = "id")int id){
        return Optional.ofNullable(managerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager ID not found")));
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getManagerByName(@PathVariable String name) {
            List<Manager> vendors = managerRepository.findByNameContaining(name);
            if (vendors.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Manager found with name: " + name);
            }
            return vendors;
        }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }
}