package com.example.healthsystem.service;

import com.example.healthsystem.dto.AddressDTO;
import com.example.healthsystem.dto.UserDTO;
import com.example.healthsystem.model.Address;
import com.example.healthsystem.model.User;
import com.example.healthsystem.model.UserType;
import com.example.healthsystem.repository.AddressRepository;
import com.example.healthsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<Map<String, Object>> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<Map<String, Object>> userDTOs = new ArrayList<>();

        for (User user : users) {
            Map<String, Object> userDTO = new UserDTO().getUserDTOResponse(user);
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    public Map<String, Object> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        Map<String, Object> userDTO = new UserDTO().getUserDTOResponse(user);
        return userDTO;
    }

    public Map<String, Object> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }

        Map<String, Object> userDTO = new UserDTO().getUserDTOResponse(user);
        return userDTO;
    }

    public List<Map<String,Object>> getServiceProviders() {
        List<User> users = userRepository.findServiceProviders();
        List<Map<String, Object>> userDTOs = new ArrayList<>();

        for (User user : users) {
            Map<String, Object> userDTO = new UserDTO().getUserDTOResponse(user);
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    public List<Map<String, Object>> getAddressByUserId(Long id) {
        List<Address> addresses = addressRepository.findByUser_Id(id);
        List<Map<String, Object>> addressesDTO = new ArrayList<>();

        for (Address address : addresses) {
            Map<String, Object> addressDTO = new AddressDTO().getAddressDTOResponse(address);
            addressesDTO.add(addressDTO);
        }

        return addressesDTO;
    }

    public ResponseEntity createUser(String name, String email, String password, String phone_number, UserType user_type) {

        try {
            if(password != null) {
                password = PasswordEncriptService.encript(password);
            }

            if (user_type == null) {
                user_type = UserType.PATIENT;
            }

            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setPhoneNumber(phone_number);
            user.setUserType(user_type);
            userRepository.save(user);
            Map<String, Object> userDTO = new UserDTO().getUserDTOResponse(user);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            Map<String, Object> response = Map.of(
                "message", "Error creating user",
                "error", e.getMessage()
            );
            return ResponseEntity.badRequest().body(response);
        }
    }

    public Map<String,Object> updateUser(User user, Long id) {
        User savedUser = userRepository.findById(id).orElse(null);
        savedUser.setName(user.getName());
        savedUser.setPhoneNumber(user.getPhoneNumber());

        User updatedUser = userRepository.save(savedUser);

        Map<String, Object> response = new UserDTO().getUserDTOResponse(updatedUser);
        return response;
    }

}
