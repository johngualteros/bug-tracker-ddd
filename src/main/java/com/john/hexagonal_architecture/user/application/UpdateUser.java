package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UpdateUser {

    private final ConvertDtoToEntityUser convertDtoToEntityUser;

    private final GetOneUserById         getOneUserById;

    private final UserRepository         userRepository;


    public Optional<UserEntity> updateUser(Long id, UserDto userDto) {

        UserEntity convertedDtoToEntityUser = convertDtoToEntityUser.convertDtoToEntity(userDto);

        Optional<UserEntity> findedUser     = getOneUserById.getOneUserById(id);

        return findedUser;

    }



}
