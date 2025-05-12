package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Integer>{
    List<Client> findByNameContaining(String name);
}
