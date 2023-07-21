package com.example.healthsystem.service;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordEncriptService {

    public PasswordEncriptService() {

    }
    public static String encript(String password) {
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encryptedPassword;
    }

    public static Boolean compare(String password, String encriptedPassword) {
        return BCrypt.checkpw(password, encriptedPassword);
    }
}
