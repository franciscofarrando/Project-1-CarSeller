package com.example.CarSeller.repositories;

import com.example.CarSeller.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
