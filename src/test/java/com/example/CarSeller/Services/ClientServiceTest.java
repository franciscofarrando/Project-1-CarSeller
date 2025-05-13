package com.example.CarSeller.Services;

import com.example.CarSeller.models.Client;
import com.example.CarSeller.repositories.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
public class ClientServiceTest {

private Client client;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @BeforeEach
    public void setUp(){
        client = new Client();
        client.setName("Marcel");
        client.setAddress("Calle Verdadera 123, Barcelona");
        client.setPhone("+34000000000");
        client.setPaid(true);
        client.setUsername("marcel99");
        client.setPassword("1234");
        System.out.println("USUARIO DE TEST: "+client);
        clientService.saveClient(client);
    }

    @AfterEach
    public void tearDown(){
        clientRepository.delete(client);
    }

    @Test
    @DisplayName("Encryptation its correct")
    public void generateEncryption(){
        assertTrue(client.getPassword().startsWith("$2a$"));
        System.out.println("USUARIO FINAL: " + client);
    }
}
