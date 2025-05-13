package com.example.CarSeller.Services;



import com.example.CarSeller.models.Client;
import com.example.CarSeller.models.Vendor;
import  com.example.CarSeller.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService {


        @Autowired
        private VendorRepository vendorRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;
        public Vendor saveVendor(Vendor vendor){
            vendor.setPassword(passwordEncoder.encode(vendor.getPassword()));
            return vendorRepository.save(vendor);
        }
    public Optional<Vendor> getVendorByUsername(String username){
        return vendorRepository.findByUsername(username);
    }
    public boolean passwordIsValid(Vendor vendor, String password){
        return passwordEncoder.matches(password, vendor.getPassword());
    }

    }

