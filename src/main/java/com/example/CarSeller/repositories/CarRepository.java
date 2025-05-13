package com.example.CarSeller.repositories;

import com.example.CarSeller.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByModel(String model);
    List<Car> findByBrand(String brand);
    List<Car> findByEngine(EEngine engine);
    List<Car> findByClient(Client client);
    List<Car> findByVendor(Vendor vendor);
}
