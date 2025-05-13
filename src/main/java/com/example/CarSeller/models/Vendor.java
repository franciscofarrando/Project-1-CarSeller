package com.example.CarSeller.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity

public class Vendor extends Person{
    @OneToMany
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private List<Car> cars;
    public Vendor(String name, String address, String phone, boolean dealClosed) {
        super(name, address, phone);

    }
}
