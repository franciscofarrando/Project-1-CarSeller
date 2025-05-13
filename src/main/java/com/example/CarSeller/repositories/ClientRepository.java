package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, Integer>{
    List<Client> findByNameContaining(String name);
    Optional<Client> findByUsername(String username);
}
