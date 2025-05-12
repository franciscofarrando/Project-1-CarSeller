package com.example.CarSeller.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Client extends Person {
    @NotNull
    private Boolean paid;

    public Client(String name, String address, String phone, Boolean paid) {
        super(name, address, phone, ERoles.ROLE_CLIENT);
        this.paid = paid;
    }
}
