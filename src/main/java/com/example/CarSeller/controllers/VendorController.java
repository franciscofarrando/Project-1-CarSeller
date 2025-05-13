package com.example.CarSeller.controllers;

import com.example.CarSeller.dtos.ManagerDTO;
import com.example.CarSeller.dtos.VendorDTO;
import com.example.CarSeller.models.*;
import com.example.CarSeller.repositories.CarRepository;
import com.example.CarSeller.repositories.RoleRepository;
import com.example.CarSeller.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Vendor> getVendorById(@PathVariable(name = "id")int id){
        return Optional.ofNullable(vendorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor ID not found")));
    }
    @GetMapping("/{vendor_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCarsByVendor(@PathVariable(name = "vendor_id") int vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found"));

        List<Car> cars = carRepository.findByVendor(vendor);
        if (cars.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cars found for the given vendor");
        }
        return cars;
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vendor> getVendorByName(@PathVariable String name) {
        List<Vendor> vendors = vendorRepository.findByNameContaining(name);
        if (vendors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No vendors found with name: " + name);
        }
        return vendors;
    }


}