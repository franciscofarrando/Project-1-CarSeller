package com.example.CarSeller.controllers;

import com.example.CarSeller.Services.ClientService;
import com.example.CarSeller.Services.JWTService;
import com.example.CarSeller.Services.ManagerService;
import com.example.CarSeller.Services.VendorService;
import com.example.CarSeller.models.*;
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
    @Autowired
    private VendorService vendorService;
    @Autowired
    private ManagerService managerService;

    @PostMapping("/login/client")
    public ResponseEntity<String> login(@RequestBody Client client) {
        Optional<Client> optionalClient = clientService.getClientByUsername(client.getUsername());

        if (optionalClient.isPresent()) {
            Client foundClient = optionalClient.get();

            List<String> roleNames = foundClient.getRole().stream()
                    .map(role -> role.getName().name())
                    .collect(Collectors.toList());

            if (clientService.passwordIsValid(foundClient, client.getPassword())) {
                String token = jwtService.generateToken(foundClient.getUsername(), roleNames);
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INCORRECT LOGIN");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }
    }

    @PostMapping("/login/vendor")
    public ResponseEntity<String> login(@RequestBody Vendor vendor) {
        Optional<Vendor> optionalVendor = vendorService.getVendorByUsername(vendor.getUsername());

        if (optionalVendor.isPresent()) {
            Vendor foundVendor = optionalVendor.get();

            List<String> roleNames = foundVendor.getRole().stream()
                    .map(role -> role.getName().name())
                    .collect(Collectors.toList());


            if (vendorService.passwordIsValid(foundVendor, vendor.getPassword())) {
                String token = jwtService.generateToken(foundVendor.getUsername(), roleNames);
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INCORRECT LOGIN");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }
    }

    @PostMapping("/login/manager")
    public ResponseEntity<String> login(@RequestBody Manager manager) {
        Optional<Manager> optionalManager = managerService.getVendorByUsername(manager.getUsername());

        if (optionalManager.isPresent()) {
            Manager foundManager = optionalManager.get();

            List<String> roleNames = foundManager.getRole().stream()
                    .map(role -> role.getName().name())
                    .collect(Collectors.toList());


            if (managerService.passwordIsValid(foundManager, manager.getPassword())) {
                String token = jwtService.generateToken(foundManager.getUsername(), roleNames);
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INCORRECT LOGIN");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }
    }

}



