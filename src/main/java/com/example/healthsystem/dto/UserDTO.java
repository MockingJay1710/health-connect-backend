package com.example.healthsystem.dto;

import com.example.healthsystem.model.User;

import java.util.Date;
import java.util.Map;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String userType;

    public UserDTO() {

    }

    public UserDTO(User user) {

    }
    public Map<String, Object> getUserDTOResponse (User user) {
        Map<String, Object> userDTO = Map.of(
            "id", user.getId(),
            "name", user.getName(),
            "email", user.getEmail()
        );
        return userDTO;
    }
}