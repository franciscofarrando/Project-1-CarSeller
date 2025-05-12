package com.example.CarSeller.dtos;

import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.EEngine;
import com.example.CarSeller.models.Vendor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
        private String brand;
        private String model;
        private EEngine engine;
        private double price;
        private Client client;
        private Vendor vendor;
    }

