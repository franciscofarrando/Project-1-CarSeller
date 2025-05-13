package com.example.CarSeller.dtos;

import com.example.CarSeller.models.Person;
import com.example.CarSeller.models.Role;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ManagerDTO extends Person {
    private String username;
    private String password;
    private List<Integer> roleIds;

    public ManagerDTO(String name, String address, String phone, String username, String password, List<Integer> roleIds) {
        super(name, address, phone);
        this.username = username;
        this.password = password;
        this.roleIds = roleIds;
    }
}
