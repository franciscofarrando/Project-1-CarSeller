package com.example.CarSeller.Services;


import com.example.CarSeller.models.Vendor;

import com.example.CarSeller.repositories.VendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VendorServiceTest {

    private Vendor vendor;

        @Autowired
        VendorService vendorService;

        @Autowired
    VendorRepository vendorRepository;

        @BeforeEach
        public void setUp(){
            vendor = new Vendor();
            vendor.setName("Maria Perez");
            vendor.setAddress("Calle Sosneado 34, Mendoza");
            vendor.setPhone("+34000000000");
            vendor.setUsername("jperez");
            vendor.setPassword("1234");
            System.out.println("USUARIO DE TEST: "+vendor);
            vendorService.saveVendor(vendor);
        }

        @AfterEach
        public void tearDown(){
            vendorRepository.delete(vendor);
        }

        @Test
        @DisplayName("Encryptation its correct")
        public void generateEncryption(){
            assertTrue(vendor.getPassword().startsWith("$2a$"));
            System.out.println("USUARIO FINAL: " + vendor);
        }
}
