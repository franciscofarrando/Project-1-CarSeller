package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Person;
import com.example.CarSeller.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }
}
