package com.example.healthsystem.dto;

import com.example.healthsystem.model.User;

import java.util.Date;
import java.util.Map;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String userType;
    private Date createdAt;
    private Date updatedAt;

    public UserDTO() {

    }

    public UserDTO(User user) {

    }
    public Map<String, Object> getUserDTOResponse (User user) {
        Map<String, Object> userDTO = Map.of(
            "id", user.getId(),
            "name", user.getName(),
            "email", user.getEmail(),
            "phone_number", user.getPhoneNumber(),
            "user_type", user.getUserType(),
            "created_at", user.getCreatedAt(),
            "updated_at", user.getUpdatedAt()
        );
        return userDTO;
    }
}