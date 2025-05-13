package com.example.CarSeller.Services;

import com.example.CarSeller.models.Manager;
import com.example.CarSeller.models.Vendor;
import com.example.CarSeller.repositories.ManagerRepository;
import com.example.CarSeller.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Manager saveManager(Manager manager){
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        return managerRepository.save(manager);
    }
}
