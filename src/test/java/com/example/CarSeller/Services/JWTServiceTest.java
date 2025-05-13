package com.example.CarSeller.Services;

import com.example.CarSeller.repositories.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JWTServiceTest {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    JWTService jwtService;

    @Test
    @DisplayName("Token's correct generation ")
    void generateToken(){
        String token = jwtService.generateToken("Test", "[ROLE_MANAGER]");
        System.out.println("TOKEN GENERATED: " + token);
    }
}
