package com.example.CarSeller.dtos;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Person;

import com.example.CarSeller.models.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class VendorDTO extends Person {
    private String username;
    private String password;
    private List<Integer> roleIds;

    public VendorDTO(String name, String address, String phone, String username, String password, List<Integer> roleIds) {
        super(name, address, phone);
        this.username = username;
        this.password = password;
        this.roleIds = roleIds;
    }
}

