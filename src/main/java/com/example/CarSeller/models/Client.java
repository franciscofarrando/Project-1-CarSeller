package com.example.CarSeller.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;



@Entity
@Getter
@Setter
public class Client extends Person {
    @NotNull
    private Boolean paid;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> role = new ArrayList<>();

    public Client(String name, String address, String phone, Boolean paid, String username, String password, Collection<Role> role) {
        super(name, address, phone);
        this.paid = paid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Client() {
    }
}
