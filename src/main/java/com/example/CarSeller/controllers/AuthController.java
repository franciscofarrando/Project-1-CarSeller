package com.example.CarSeller.controllers;

import com.example.CarSeller.Services.ClientService;
import com.example.CarSeller.Services.JWTService;
import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.ERoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private JWTService jwtService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Client client){
        Optional<Client> optionalClient = clientService.getClientByUsername(client.getUsername());

        if(optionalClient.isPresent()){
            Client foundClient = optionalClient.get();

            List<ERoles> roleNames = foundClient.getRole().stream()
                    .map(role -> role.getName())
                    .collect(Collectors.toList());

            if (clientService.passwordIsValid(foundClient, client.getPassword())){
                String token = jwtService.generateToken(foundClient.getUsername(), roleNames.toString());
                return ResponseEntity.ok(token);
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INCORRECT LOGIN");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CLIENT NOT FOUND");
        }
    }


}
