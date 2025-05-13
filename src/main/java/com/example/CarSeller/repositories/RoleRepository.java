package com.example.CarSeller.repositories;

import com.example.CarSeller.models.ERoles;
import com.example.CarSeller.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERoles name);
}
