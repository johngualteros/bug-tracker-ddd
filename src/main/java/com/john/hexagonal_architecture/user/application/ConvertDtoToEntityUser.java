package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;

public final class ConvertDtoToEntityUser {

    public UserEntity convertDtoToEntity(UserDto userDto) {

        UserEntity user = new UserEntity();

        user.setName(userDto.getName() + userDto.getLastname());

        user.setEmail(userDto.getEmail());

        user.setPhoto(userDto.getPhoto());

        user.setPassword(userDto.getPassword());

        return user;
    }

}
