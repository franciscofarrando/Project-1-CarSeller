package com.example.CarSeller.Services;

import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Manager;
import com.example.CarSeller.repositories.ClientRepository;
import com.example.CarSeller.repositories.ManagerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class ManagerServiceTest {


     private Manager manager;

        @Autowired
        ManagerService managerService;

        @Autowired
    ManagerRepository managerRepository;

        @BeforeEach
        public void setUp(){
            manager = new Manager();
            manager.setName("Joaquin Vera");
            manager.setAddress("Calle Soldado 123, Barcelona");
            manager.setPhone("+34000000000");
            manager.setUsername("jvera");
            manager.setPassword("1234");
            System.out.println("USUARIO DE TEST: "+manager);
            managerService.saveManager(manager);
        }

        @AfterEach
        public void tearDown(){
            managerRepository.delete(manager);
        }

        @Test
        @DisplayName("Encryptation its correct")
        public void generateEncryption(){
            assertTrue(manager.getPassword().startsWith("$2a$"));
            System.out.println("USUARIO FINAL: " + manager);
        }
    }

