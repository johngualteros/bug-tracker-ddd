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


    /*
    "name": "solved",
    "description": "this category is for save the bugs already solved",
    "color": "rgb(255,0,10)",
    "team": {
        "id": 1
    }
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity category){

        categoryRepository.save(category);

        return ResponseEntity.status(200).body(category);

    }

}
