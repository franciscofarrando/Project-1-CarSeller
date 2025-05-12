package com.example.CarSeller.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter


public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String phone;
    @NotNull
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

    public Person(String name, String address, String phone) {
    }
}
