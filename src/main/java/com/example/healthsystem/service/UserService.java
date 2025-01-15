package com.example.healthsystem.service;

import com.example.healthsystem.model.User;
import com.example.healthsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new RuntimeException("User with email " + email + " not found");
        }
        return user;
    }
}
