package com.example.CarSeller.controllers;

import com.example.CarSeller.dtos.ManagerDTO;
import com.example.CarSeller.models.Manager;
import com.example.CarSeller.models.Role;
import com.example.CarSeller.repositories.ManagerRepository;
import com.example.CarSeller.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Manager> getManagerById(@PathVariable(name = "id")int id){
        return Optional.ofNullable(managerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager ID not found")));
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Manager> getManagerByName(@PathVariable String name) {
            List<Manager> vendors = managerRepository.findByNameContaining(name);
            if (vendors.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Manager found with name: " + name);
            }
            return vendors;
        }

//POST
   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    */
@PostMapping
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

    return ResponseEntity.ok(managerRepository.save(manager));
}
    //PATCH
    @PatchMapping("id/{id}")
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
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManager(@PathVariable int id) {
        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager ID not found"));

        managerRepository.delete(existingManager);
    }
}