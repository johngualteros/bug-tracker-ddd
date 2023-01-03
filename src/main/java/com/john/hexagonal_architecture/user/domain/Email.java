package com.john.hexagonal_architecture.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Email {

    private String to;

    private String body;

    private String subject;

    private String attachment;

}
