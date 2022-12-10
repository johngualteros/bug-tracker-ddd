package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UpdateUser {

    private final ConvertDtoToEntityUser convertDtoToEntityUser;

    private final GetOneUserById         getOneUser;

    private final PasswordEncoder        passwordEncoder;

    public Optional<UserEntity> updateUser(Long id, UserDto userDto) {

        UserEntity convertedDtoToEntityUser = convertDtoToEntityUser.convertDtoToEntity(userDto);

        Optional<UserEntity> foundUser      = getOneUser.getOneUserById(id);

        if(foundUser.isEmpty()){
            return Optional.empty();
        }

        foundUser.get().setName(convertedDtoToEntityUser.getName());

        foundUser.get().setEmail(convertedDtoToEntityUser.getEmail());

        foundUser.get().setPhoto(convertedDtoToEntityUser.getPhoto());

        foundUser.get().setPassword(passwordEncoder.encode(convertedDtoToEntityUser.getPassword()));

        return foundUser;

    }



}
