package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ValidateUserLoginTest {

    @Autowired
    @MockBean
    private UserRepository userRepository;

    @Autowired
    @MockBean
    private ValidateUserLogin validateUserLogin;

    @Autowired
    @MockBean
    private PasswordEncoder passwordEncoder;

    UserEntity user;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        user = new UserEntity();

        user.setName("johngualterosgarcia");
        user.setEmail("john@gmail.com");
        user.setPassword(passwordEncoder.encode("example_password"));
        user.setId(1L);

    }

    @Test
    void validateUserLoginWithUsername() {

        Optional<UserEntity> userFound = validateUserLogin.validateUserLoginWithUsername(user.getName());

        boolean existsUser = userFound.isPresent();

        when(existsUser).thenReturn(true);


    }
}