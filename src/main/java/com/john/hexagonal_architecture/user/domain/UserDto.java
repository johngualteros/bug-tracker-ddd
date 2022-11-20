package com.john.hexagonal_architecture.user.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public final class UserDto {

    @NotNull
    private Long   id;

    @Pattern(regexp="/[a-zA-Z]/gi", message="your name only can contains letters")
    @NotEmpty
    private String name;

    @Pattern(regexp="/[a-zA-Z]/gi", message="your lastname only can contains letters")
    @NotEmpty
    private String lastname;

    @Email
    @NotEmpty
    private String email;

    private String photo;

    @NotEmpty
    private String password;

}
