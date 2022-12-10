package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class ValidateUserLogin {

    private final UserRepository userRepository;

    public Optional<UserEntity> validateUserLoginWithUsername(String name){

        return userRepository.loginMethodWithUsername(name);

    }

}
