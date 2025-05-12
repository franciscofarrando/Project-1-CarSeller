package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Vendor;
import com.example.CarSeller.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    VendorRepository vendorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}