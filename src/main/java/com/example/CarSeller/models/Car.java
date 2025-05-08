package com.example.CarSeller.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private EEngine engine;
    private double price;
    private int clientId;
    private int vendorId;
}
