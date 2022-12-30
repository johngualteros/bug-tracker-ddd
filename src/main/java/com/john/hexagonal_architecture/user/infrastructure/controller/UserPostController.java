package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.EmailSenderService;
import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.application.ValidateIfEmailAlreadyExists;
import com.john.hexagonal_architecture.user.domain.Email;
import com.john.hexagonal_architecture.user.domain.UserDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class UserPostController {

    private final UserRepository               userRepository;

    private final PasswordEncoder              passwordEncoder;

    private final EmailSenderService           emailService;

    private final ValidateIfEmailAlreadyExists validateIfEmailAlreadyExists;

    @PostMapping("/users")
    public ResponseEntity<UserEntity> saveOneUser (@RequestBody UserDto userDto) throws MessagingException {

        UserEntity user = convertDtoToModelUser(userDto);

        Optional<UserEntity> userAlreadyExists = validateIfEmailAlreadyExists
               .validateIfEmailAlreadyRegistered(user.getEmail());

        if(userAlreadyExists.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
        }

        String message = "muchas gracias por registrarte en nuestro sistema \na continuacion encontraras el usuario para que puedas iniciar sesion: " + user.getName();

        Email email = new Email(
                user.getEmail(),
                message,
                "Registro exitoso en Jbugs",
                "\"C:\\\\Users\\\\jumbo170\\\\Downloads\\\\github.webp\""
        );

        emailService.sendEmailWithAttachment(email);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(user);

    }

    private UserEntity convertDtoToModelUser(UserDto userDto) {

        UserEntity user = new UserEntity();

        user.setName(userDto.getName() + userDto.getLastname());

        user.setEmail(userDto.getEmail());

        user.setPassword( userDto.getPassword());

        return user;

    }

}
