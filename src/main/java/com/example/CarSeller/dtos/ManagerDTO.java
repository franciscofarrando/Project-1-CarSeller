package com.example.CarSeller.dtos;

import com.example.CarSeller.models.Person;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class ManagerDTO extends Person {
    public ManagerDTO(String name, String address, String phone) {
        super(name, address, phone);
    }
}
