package com.example.CarSeller.dtos;

import com.example.CarSeller.models.Person;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class ClientDTO extends Person {
    private Boolean paid;

    public ClientDTO(String name, String address, String phone, Boolean paid) {
        super(name, address, phone);
        this.paid = paid;
    }
}
