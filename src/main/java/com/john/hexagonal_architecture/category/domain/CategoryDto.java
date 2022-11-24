package com.john.hexagonal_architecture.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor

public class CategoryDto {

    @NotNull
    private Long   id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private String color;

}
