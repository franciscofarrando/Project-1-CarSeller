package com.example.CarSeller.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor extends Person{
    private boolean dealClosed;
    @OneToOne
    @JoinColumn(name = "car_sold", referencedColumnName = "carId")
    private Car carSold;
}
