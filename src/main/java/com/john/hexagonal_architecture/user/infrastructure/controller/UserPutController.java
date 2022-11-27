package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.UpdateUser;
import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class UserPutController {

    private final UserRepository userRepository;

    private final UpdateUser updateUserRepository;

    @PutMapping("/users/{id}")
    public UserEntity updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) {

        Optional<UserEntity> userUpdated = updateUserRepository.updateUser(id, userDto);

        if (userUpdated.isPresent()){

            UserEntity castedEntityUser  = UserEntity.class.cast(userUpdated);

            return userRepository.save(castedEntityUser);

        }

        return null;
    }

}
