package com.example.CarSeller.controllers;


import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Manager;
import com.example.CarSeller.models.Person;
import com.example.CarSeller.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> getClientById(@PathVariable(name = "id")int id){
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client ID not found")));
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClientByName(@PathVariable String name) {
        List<Client> vendors = clientRepository.findByNameContaining(name);
        if (vendors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Client found with name: " + name);
        }
        return vendors;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
