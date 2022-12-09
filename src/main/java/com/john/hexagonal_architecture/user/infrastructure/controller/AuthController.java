package com.john.hexagonal_architecture.user.infrastructure.controller;

import com.john.hexagonal_architecture.user.application.ValidateUserLogin;
import com.john.hexagonal_architecture.user.domain.AuthDto;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping(value = "/api/v1/")

public class AuthController {

    private final ValidateUserLogin validateUserLogin;

    @GetMapping("/authenticate")
    public String login(){

        //Optional<UserEntity> userValidated = validateUserLogin
          //      .validateUserLoginWithUsernameAndPassword(user.getUsername(), user.getPassword());

        //if(userValidated.isPresent()){

            System.out.println("si sirvio");

            return getJWTToken("johngualteros");

        //}

        //System.out.println("incorrect Password");
        //return "username or password incorrect";

    }

    private String getJWTToken(String username){

        String secretKey = "mySecretKey";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("johnJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 120000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
