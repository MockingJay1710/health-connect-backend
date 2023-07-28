package com.example.healthsystem.controller;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.healthsystem.dto.UserDTO;
import com.example.healthsystem.model.Address;
import com.example.healthsystem.model.UserType;
import com.example.healthsystem.service.UserService;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.healthsystem.repository.UserRepository;
import com.example.healthsystem.model.User;

@RestController
public class UserController {
  private final UserService userService;
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @RequestMapping("/users")
  public ResponseEntity<?> getUsers() {
    List<Map<String, Object>> users =  userService.getAllUsers();;
    Map<String, Object> response = new HashMap<>();
    Boolean hasUser = !users.isEmpty();

    if (hasUser) {
      return ResponseEntity.ok(users);
    }

    response.put("message", "No users found");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @PostMapping
  @RequestMapping("/users/create")
  public ResponseEntity createUser(@RequestBody User user) {
    String name = user.getName();
    String email = user.getEmail();
    String password = user.getPassword();
    String phone_number = user.getPhoneNumber();
    UserType user_type = user.getUserType();
    Map<String, Object> foundUser = userService.getUserByEmail(email);

    if (foundUser != null) {
      return ResponseEntity.status(409).body(
        Map.of("message", "User already exists")
      );
    }

    ResponseEntity response = userService.createUser(name, email, password, phone_number, user_type);
    return response;
  }

  @GetMapping
  @RequestMapping("/users/{id}")
  public ResponseEntity getUserById(@PathVariable(value="id") String id) {
    Map<String, Object> response = new HashMap<>();
    try {
      Long userId = Long.parseLong(id);
      Map<String, Object> user = userService.getUserById(userId);

      if (user != null) {
        return ResponseEntity.ok(user);
      }
      return ResponseEntity.status(404).body(
        Map.of("message", "User not found")
      );
    } catch (Exception e) {
      response.put("message", "User not found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }


  @PostMapping
  @RequestMapping("/users/email")
  public ResponseEntity getUserByEmail(@RequestBody Map<String, Object> req) {
    Map<String, Object> response = new HashMap<>();
    try {
      String email = req.get("email").toString();
      Map<String, Object> user = userService.getUserByEmail(email);

      if (user != null) {
        return ResponseEntity.ok(user);
      }
      return ResponseEntity.status(404).body(
              Map.of("message", "User not found")
      );
    } catch (Exception e) {
      response.put("message", "User not found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  @GetMapping
  @RequestMapping("/users/providers")
  public List<Map<String,Object>> getServiceProviders() {
    List<Map<String, Object>> serviceProviders = userService.getServiceProviders();
    return serviceProviders;
  }

  @GetMapping
  @RequestMapping("/users/{id}/address")
  public List<Map<String, Object>> getUserSavedAddress(@PathVariable(value="id") String id) {
    Long userId = Long.parseLong(id);
    List<Map<String, Object>> address = userService.getAddressByUserId(userId);

    return address;
  }


  @PutMapping("/users/update/{id}")
  public Map<String, Object> updateUser(@RequestBody User user, @PathVariable(value="id") String id) {
    Long userId = Long.parseLong(id);
    Map<String, Object> response = userService.updateUser(user, userId);

    return response;
  }
}
