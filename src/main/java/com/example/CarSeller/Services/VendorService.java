package com.example.CarSeller.Services;



import com.example.CarSeller.models.Vendor;
import  com.example.CarSeller.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    }

