package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import org.springframework.stereotype.Service;

@Service
public final class ConvertDtoToEntityUser {

    public UserEntity convertDtoToEntity(UserDto userDto) {

        UserEntity user = new UserEntity();

        user.setName(userDto.getName() + userDto.getLastname());

        user.setEmail(userDto.getEmail());

        user.setPassword(userDto.getPassword());

        return user;
    }

}
