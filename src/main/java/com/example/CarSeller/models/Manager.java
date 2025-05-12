package com.example.CarSeller.models;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Manager extends Person {
    public Manager(String name, String address, String phone) {
        super(name, address, phone, ERoles.ROLE_MANAGER);
    }
}
