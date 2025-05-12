package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.Vendor;
import com.example.CarSeller.repositories.CarRepository;
import com.example.CarSeller.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    CarRepository carRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}