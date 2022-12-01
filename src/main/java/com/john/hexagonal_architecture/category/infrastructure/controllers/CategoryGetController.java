package com.john.hexagonal_architecture.category.infrastructure.controllers;

import com.john.hexagonal_architecture.category.application.CategoryRepository;
import com.john.hexagonal_architecture.category.application.GetOneCategoryById;
import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class CategoryGetController {

    private final CategoryRepository categoryRepository;

    private final GetOneCategoryById getOneCategoryById;

    @GetMapping("/categories")
    public List<CategoryEntity> getAllCategories(){

        return categoryRepository.findAll();

    }

    @GetMapping("/categories/{id}")
    public Optional<CategoryEntity> getOneCategoryById(@PathVariable Long id){

        return getOneCategoryById.getOneCategoryIfExists(id);

    }
}
