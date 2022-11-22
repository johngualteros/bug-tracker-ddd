package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@AllArgsConstructor

public class GetOneUserById {

    private final UserRepository userRepository;

    public Optional<UserEntity> getOneUserById(Long id){

        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isEmpty()){
            return null;
        }

        return user;

    }

}
