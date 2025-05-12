package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Manager;
import com.example.CarSeller.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }
}