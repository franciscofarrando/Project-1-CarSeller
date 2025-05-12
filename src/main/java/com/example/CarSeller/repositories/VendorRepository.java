package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.ERoles;
import com.example.CarSeller.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
