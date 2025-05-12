package com.example.CarSeller.controllers;

import com.example.CarSeller.dtos.CarDTO;
import com.example.CarSeller.models.Car;
import com.example.CarSeller.models.EEngine;
import com.example.CarSeller.models.Vendor;
import com.example.CarSeller.repositories.CarRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Optional<Car> getCarById(@PathVariable(name = "id")int id){
        return Optional.ofNullable(carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car ID not found")));
    }
    @GetMapping("/brand/{brand}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCarByBrand(@PathVariable(name = "brand") String brand) {
        List<Car> cars = carRepository.findByBrand(brand);
        if (cars.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cars with the given brand not found");
        }
        return cars;
    }
    @GetMapping("/model/{model}")
    @ResponseStatus(HttpStatus.OK)

    public List<Car> getCarByModel(@PathVariable(name = "model")String model) {
        List<Car> cars = carRepository.findByModel(model);
        if (cars.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cars with the given brand not found");
        }
        return cars;
    }




    @GetMapping("/engine/{engine}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCarByEngine(@PathVariable(name = "engine") EEngine engine) {
        List<Car> cars = carRepository.findByEngine(engine);
        if (cars.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cars with the given engine type not found");
        }
        return cars;
    }


    //POST

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody @Valid Car car){
        return carRepository.save(car);
    }

    //PUT
    @PutMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateVendor(@PathVariable int id, @RequestBody Car car){
        Car existingCar = carRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor ID not found"));
        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setEngine(car.getEngine());
        existingCar.setPrice(car.getPrice());
        existingCar.setVendor(car.getVendor());
        existingCar.setClient(car.getClient());

        return carRepository.save(existingCar);
    }
    //PATCH
    @PatchMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car changeCarInfo(@PathVariable int id, @RequestBody CarDTO carDTO){
        Car existingCar = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    if (carDTO.getVendor() != null){
        existingCar.setVendor(carDTO.getVendor());
    }
        if (carDTO.getClient() != null){
            existingCar.setClient(carDTO.getClient());
        }
    return carRepository.save(existingCar);
    }
}
