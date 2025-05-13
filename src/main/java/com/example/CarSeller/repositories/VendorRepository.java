package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.ERoles;
import com.example.CarSeller.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    List<Vendor> findByNameContaining(String name);
    Optional<Vendor> findByUsername(String username);
}
