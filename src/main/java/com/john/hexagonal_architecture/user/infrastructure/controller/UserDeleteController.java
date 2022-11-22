package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class UserDeleteController {

    private final UserRepository userRepository;

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {

        Optional<UserEntity> user = userRepository.findById(id);

        userRepository.deleteById(id);

        return ResponseEntity.status(202).body(user);

    }

}
