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
public class ClientDTO extends Person {
    private Boolean paid;
    private String username;
    private String password;
    private List<Integer> roleIds;

    public ClientDTO(String name, String address, String phone, Boolean paid, String username, String password, List<Integer> roleIds) {
        super(name, address, phone);
        this.paid = paid;
        this.username = username;
        this.password = password;
        this.roleIds = roleIds;
    }
}
