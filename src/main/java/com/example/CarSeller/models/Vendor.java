package com.example.CarSeller.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter

@Entity

public class Vendor extends Person{
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> role = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private List<Car> cars;

    public Vendor(String name, String address, String phone, String username, String password, Collection<Role> role) {
        super(name, address, phone);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Vendor() {
    }
}
