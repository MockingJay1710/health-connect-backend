package com.example.healthsystem.controller;

import com.example.healthsystem.model.Address;
import com.example.healthsystem.model.User;
import com.example.healthsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/address/save")
    public Map<String, Object> saveAddress(@RequestBody Address address) {
        Map<String, Object> response = addressService.createAddress(address);

        return response;
    }

    @PutMapping("/address/update/{id}")
    public Map<String, Object> updateAddress(@RequestBody Address address, @PathVariable(value="id") Long id) {
        Map<String, Object> response = addressService.updateAddress(address, id);

        return response;
    }
}
