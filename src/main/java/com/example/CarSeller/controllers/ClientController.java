package com.example.CarSeller.controllers;


import com.example.CarSeller.dtos.CarDTO;
import com.example.CarSeller.dtos.ClientDTO;
import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Manager;
import com.example.CarSeller.models.Person;
import com.example.CarSeller.repositories.ClientRepository;
import jakarta.validation.Valid;
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
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> getClientById(@PathVariable(name = "id") int id) {
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

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    //PATCH
    @PatchMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client changeClientInfo(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (clientDTO.getName() != null) {
            existingClient.setName(clientDTO.getName());
        }

        if (clientDTO.getAddress() != null) {
            existingClient.setAddress(clientDTO.getAddress());
        }

        if (clientDTO.getPhone() != null) {
            existingClient.setPhone(clientDTO.getPhone());
        }
        if (clientDTO.getPaid() != null) {
            existingClient.setPaid(clientDTO.getPaid());
        }


        return clientRepository.save(existingClient);
    }

    //DELETE
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable int id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

        if (client.getPaid() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client cannot be deleted because 'paid' is not null");
        }

        clientRepository.deleteById(id);
    }
}
