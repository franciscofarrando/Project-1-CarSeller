package com.example.CarSeller.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Getter
@Setter

public class Manager extends Person {
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> role = new ArrayList<>();

    public Manager(String name, String address, String phone, String username, String password, Collection<Role> role) {
        super(name, address, phone);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Manager() {
    }
}
