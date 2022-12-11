package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {

        UserEntity userTest = new UserEntity(
                "johngualteros",
                "gualterosjohn40@gmail.com",
                "no-content",
                passwordEncoder.encode("testPasswordEncrypted")
        );

        userRepository.save(userTest);

    }
}