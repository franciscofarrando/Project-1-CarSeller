package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer>{
}
