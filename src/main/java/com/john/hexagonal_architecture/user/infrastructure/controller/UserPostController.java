package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class UserPostController {

    private final UserRepository userRepository;


    @PostMapping("/users")
    public ResponseEntity<UserEntity> saveOneUser (@RequestBody UserDto userDto) {

        UserEntity user = convertDtoToModelUser(userDto);

        userRepository.save(user);

        return ResponseEntity.ok(user);

    }

    private UserEntity convertDtoToModelUser(UserDto userDto) {

        UserEntity user = new UserEntity();

        user.setName(userDto.getName() + userDto.getLastname());

        user.setEmail(userDto.getEmail());

        user.setPhoto(userDto.getPhoto());

        user.setPassword( userDto.getPassword());

        return user;

    }

}
