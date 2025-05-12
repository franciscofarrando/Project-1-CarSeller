package com.example.CarSeller.dtos;

import com.example.CarSeller.models.Person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class VendorDTO extends Person {
    public VendorDTO(String name, String address, String phone) {
        super(name, address, phone);
    }
}

