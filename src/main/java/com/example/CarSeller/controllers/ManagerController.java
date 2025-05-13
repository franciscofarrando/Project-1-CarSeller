package com.example.CarSeller.controllers;

import com.example.CarSeller.Services.ClientService;
import com.example.CarSeller.Services.ManagerService;
import com.example.CarSeller.Services.VendorService;
import com.example.CarSeller.dtos.CarDTO;
import com.example.CarSeller.dtos.ClientDTO;
import com.example.CarSeller.dtos.ManagerDTO;
import com.example.CarSeller.dtos.VendorDTO;
import com.example.CarSeller.models.*;
import com.example.CarSeller.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    VendorService vendorService;
    @Autowired
    ManagerService managerService;


    @GetMapping("/manager/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }

    @GetMapping("/manager/get/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Manager> getManagerById(@PathVariable(name = "id")int id){
        return Optional.ofNullable(managerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager ID not found")));
    }

    @GetMapping("/manager/get/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getManagerByName(@PathVariable String name) {
            List<Manager> vendors = managerRepository.findByNameContaining(name);
            if (vendors.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Manager found with name: " + name);
            }
            return vendors;
        }


@PostMapping("/manager/post")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<Manager> createManager(@RequestBody ManagerDTO managerDTO) {
    List<Role> roles = roleRepository.findAllById(managerDTO.getRoleIds());

    Manager manager = new Manager(
            managerDTO.getName(),
            managerDTO.getAddress(),
            managerDTO.getPhone(),
            managerDTO.getUsername(),
            managerDTO.getPassword(),
            roles
    );

    return ResponseEntity.ok(managerService.saveManager(manager));

}
    //PATCH
    @PatchMapping("/manager/patch/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Manager changeManagerInfo(@PathVariable int id, @RequestBody ManagerDTO managerDTO){
        Manager existingManager = managerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (managerDTO.getName() != null){
            existingManager.setName(managerDTO.getName());
        }

        if (managerDTO.getAddress() != null){
            existingManager.setAddress(managerDTO.getAddress());
        }

        if (managerDTO.getPhone() != null){
            existingManager.setPhone(managerDTO.getPhone());
        }

        return managerRepository.save(existingManager);
    }

    //DELETE
    @DeleteMapping("/manager/delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManager(@PathVariable int id) {
        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager ID not found"));

        managerRepository.delete(existingManager);
    }

    //POST UN CAR
    @PostMapping("/car/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody @Valid Car car){
        return carRepository.save(car);
    }

    //PUT
    @PutMapping("/car/put/id/{id}")
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
    @PatchMapping("/car/patch/id/{id}")
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

    //POST CLIENT

    @PostMapping("/client/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        List<Role> roles = roleRepository.findAllById(clientDTO.getRoleIds());

        Client client = new Client(
                clientDTO.getName(),
                clientDTO.getAddress(),
                clientDTO.getPhone(),
                clientDTO.getPaid(),
                clientDTO.getUsername(),
                clientDTO.getPassword(),
                roles
        );

        return ResponseEntity.ok(clientService.saveClient(client));

    }

    //PATCH
    @PatchMapping("/client/patch/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client changeClientInfo(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (clientDTO.getName() != null) {
            existingClient.setName(clientDTO.getName());
        }

        if (clientDTO.getAddress() != null) {
            existingClient.setAddress(clientDTO.getAddress());
        }

        if (clientDTO.getPhone() != null) {
            existingClient.setPhone(clientDTO.getPhone());
        }
        if (clientDTO.getPaid() != null) {
            existingClient.setPaid(clientDTO.getPaid());
        }


        return clientRepository.save(existingClient);
    }

    //DELETE
    @DeleteMapping("/client/delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable int id) {
        Optional<Client> client = clientRepository.findById(id);
                        clientRepository.deleteById(id);
    }

    //POST VENDOR

    @PostMapping("/vendor/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vendor> createVendor(@RequestBody VendorDTO vendorDTO) {
        List<Role> roles = roleRepository.findAllById(vendorDTO.getRoleIds());

        Vendor vendor  = new Vendor(
                vendorDTO.getName(),
                vendorDTO.getAddress(),
                vendorDTO.getPhone(),
                vendorDTO.getUsername(),
                vendorDTO.getPassword(),
                roles
        );

        return ResponseEntity.ok(vendorService.saveVendor(vendor));

    }


    //PUT
    @PutMapping("/vendor/put/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vendor updateVendor(@PathVariable int id, @RequestBody Vendor vendor){
        Vendor existingVendor = vendorRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor ID not found"));
        existingVendor.setName(vendor.getName());
        existingVendor.setAddress(vendor.getAddress());
        existingVendor.setPhone(vendor.getPhone());
        existingVendor.setRole(vendor.getRole());

        return vendorRepository.save(existingVendor);
    }
    //PATCH
    @PatchMapping("/vendor/patch/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vendor changeVendorInfo(@PathVariable int id, @RequestBody VendorDTO vendorDTO){
        Vendor existingVendor = vendorRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (vendorDTO.getName() != null){
            existingVendor.setName(vendorDTO.getName());
        }

        if (vendorDTO.getAddress() != null){
            existingVendor.setAddress(vendorDTO.getAddress());
        }

        if (vendorDTO.getPhone() != null){
            existingVendor.setPhone(vendorDTO.getPhone());
        }

        return vendorRepository.save(existingVendor);
    }
    @DeleteMapping("/vendor/delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVendor(@PathVariable int id) {
        Vendor existingVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor ID not found"));

        List<Car> cars = carRepository.findByVendor(existingVendor);
        if (!cars.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete vendor with assigned cars");
        }

        vendorRepository.delete(existingVendor);
    }

}