package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class UserRepositoryTest {

    @Autowired
    @MockBean
    private UserRepository  userRepository;

    @Autowired
    @MockBean
    private PasswordEncoder passwordEncoder;

    private UserEntity user;

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
    public void findAll() {

        when(userRepository.findAll())
                .thenReturn(Collections.singletonList(user));

        assertNotNull(userRepository.findAll());

    }

    @Test
    void save() {

        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        assertNotNull(userRepository.save(new UserEntity()));

    }

    @Test
    void delete() {

        userRepository.deleteById(1L);

        when(userRepository.findById(1L))
                .thenReturn(Optional.ofNullable(user))
                .thenReturn(null);

    }

}