package com.example.CarSeller.repositories;

import com.example.CarSeller.models.*;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CarRepository extends JpaRepository<Car, Integer> {

}
