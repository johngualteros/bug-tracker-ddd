package com.john.hexagonal_architecture.category.infrastructure.controllers;

import com.john.hexagonal_architecture.category.application.CategoryRepository;
import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class CategoryPostController {

    private final CategoryRepository categoryRepository;


    @PostMapping("/categories")
    public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity category){

        categoryRepository.save(category);

        return ResponseEntity.status(200).body(category);

    }

}
