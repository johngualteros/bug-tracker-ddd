package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.GetUsersNotLikeEmailGmail;
import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.application.ValidateUserLogin;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class UserGetController {

    private final UserRepository            userRepository;

    private final GetUsersNotLikeEmailGmail userEmailRepository;

    private final ValidateUserLogin         validateUserLogin;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<UserEntity>> getOneUser(@PathVariable Long id){

        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isEmpty()){
            return (ResponseEntity<Optional<UserEntity>>) ResponseEntity.notFound();
        }

        return ResponseEntity.ok(user);

    }

    @GetMapping("/usersNotGmail")
    public List<UserEntity> getAllUser(){
        return userEmailRepository.getAllUserWithNotGmailEmail();
    }

    @GetMapping("/searchUser/{username}")
    public Optional<UserEntity> getUserByUsername(@PathVariable String username){

        return validateUserLogin.validateUserLoginWithUsername(username);

    }
}
