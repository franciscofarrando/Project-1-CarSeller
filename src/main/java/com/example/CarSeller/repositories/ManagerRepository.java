package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.ERoles;
import com.example.CarSeller.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    List<Manager> findByNameContaining(String name);
    Optional<Manager> findByUsername(String username);
}
