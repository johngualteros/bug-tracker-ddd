package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class UserPutController {

    private final UserRepository userRepository;

    /*@PutMapping("/users/{id}")
    public UserEntity updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) {

    }*/

}
