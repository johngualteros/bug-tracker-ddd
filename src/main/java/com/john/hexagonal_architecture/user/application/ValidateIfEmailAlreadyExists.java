package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class ValidateIfEmailAlreadyExists {

    private final UserRepository userRepository;

    public Optional<UserEntity> validateIfEmailAlreadyRegistered(String email){

        return userRepository.validateEmailExists(email);

    }

}
