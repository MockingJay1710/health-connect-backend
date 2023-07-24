package com.example.healthsystem.service;

import com.example.healthsystem.dto.AddressDTO;
import com.example.healthsystem.model.Address;
import com.example.healthsystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Map<String,Object> createAddress(Address address) {
        Address savedAddress = addressRepository.save(address);
        Map<String, Object> response = new AddressDTO().getAddressDTOResponse(savedAddress);
        return response;
    }

    public Map<String,Object> updateAddress(Address address, Long id) {
        Address savedAddress = addressRepository.getReferenceById(id);
        savedAddress.setStreet(address.getStreet());
        savedAddress.setComplement(address.getComplement());
        savedAddress.setCity(address.getCity());
        savedAddress.setState(address.getState());
        savedAddress.setZipCode(address.getZipCode());
        savedAddress.setLatitude(address.getLatitude());
        savedAddress.setLongitude(address.getLongitude());

        Address newAddress = addressRepository.save(savedAddress);

        Map<String, Object> response = new AddressDTO().getAddressDTOResponse(newAddress);
        return response;
    }

}
