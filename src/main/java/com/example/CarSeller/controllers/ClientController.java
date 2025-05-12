package com.example.CarSeller.controllers;


import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Person;
import com.example.CarSeller.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
