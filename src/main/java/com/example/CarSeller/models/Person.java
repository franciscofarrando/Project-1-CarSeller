package com.example.CarSeller.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter


public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    @Enumerated(EnumType.STRING)
    private ERoles role;

    public Person() {
    }

    public Person(String name, String address, String phone, ERoles role) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

}
