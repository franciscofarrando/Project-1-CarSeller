package com.example.CarSeller.Services;

import com.example.CarSeller.models.Client;

import com.example.CarSeller.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client saveClient(Client client){
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    public boolean passwordIsValid(Client client, String password){
        return passwordEncoder.matches(password, client.getPassword());
    }

    public Optional<Client> getClientByUsername(String username){
        return clientRepository.findByUsername(username);
    }
}
