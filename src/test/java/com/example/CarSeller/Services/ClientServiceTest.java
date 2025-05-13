package com.example.CarSeller.Services;

import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Person;
import com.example.CarSeller.models.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static com.example.CarSeller.models.ERoles.ROLE_CLIENT;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    ClientService clientService;

    @Test
    @DisplayName("Generate Person")
    public void generateClient(){
        Client client = new Client();

    }
}
