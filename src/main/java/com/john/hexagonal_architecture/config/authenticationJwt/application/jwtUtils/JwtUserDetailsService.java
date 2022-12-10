package com.john.hexagonal_architecture.config.authenticationJwt.application.jwtUtils;

import com.john.hexagonal_architecture.user.application.UserRepository;
import com.john.hexagonal_architecture.user.application.ValidateUserLogin;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ValidateUserLogin validateUserLogin;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userFound = getUserByUsername(username);

        if(userFound.isPresent()){
            return new User(userFound.get().getName(),
                    userFound.get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Optional<UserEntity> getUserByUsername(String username){

        return validateUserLogin.validateUserLoginWithUsername(username);

    }
}
