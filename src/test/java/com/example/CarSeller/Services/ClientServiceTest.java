package com.example.CarSeller.Services;

import com.example.CarSeller.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceTest {
    @Autowired
    PersonService personService;

    @Test
    @DisplayName("Generate Person")
    public void generatePerson(){
        Person person = new Person();
        
    }
}
