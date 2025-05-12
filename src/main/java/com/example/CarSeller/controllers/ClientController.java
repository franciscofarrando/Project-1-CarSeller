package com.example.CarSeller.controllers;


import com.example.CarSeller.models.Client;
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
