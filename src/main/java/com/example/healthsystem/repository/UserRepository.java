package com.example.healthsystem.repository;

import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findById(String id);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.user_type != 'PATIENT'")
    List<User> findServiceProviders();


}
