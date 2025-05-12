package com.example.CarSeller.controllers;

import com.example.CarSeller.models.Car;
import com.example.CarSeller.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars(){
        return carRepository.findAll();
        }
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Car> getCarById(@PathVariable(name = "carId")int id){
        return carRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }
}
