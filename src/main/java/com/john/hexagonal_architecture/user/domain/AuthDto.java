package com.john.hexagonal_architecture.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AuthDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

}
