package com.example.CarSeller.controllers;


import com.example.CarSeller.models.Person;
import com.example.CarSeller.repositories.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody @Valid Person person){
        return personRepository.save(person);
    }

}
