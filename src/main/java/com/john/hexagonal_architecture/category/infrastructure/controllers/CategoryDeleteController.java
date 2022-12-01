package com.john.hexagonal_architecture.category.infrastructure.controllers;

import com.john.hexagonal_architecture.category.application.CategoryRepository;
import com.john.hexagonal_architecture.category.application.GetOneCategoryById;
import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class CategoryDeleteController {

    private final CategoryRepository categoryRepository;

    private final GetOneCategoryById getOneCategoryById;

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){

        Optional<CategoryEntity> categoryFound = getOneCategoryById.getOneCategoryIfExists(id);

        if(categoryFound.isPresent()){

            categoryRepository.deleteById(id);

            return ResponseEntity.status(202).body(categoryFound);

        }

        return (ResponseEntity<?>) ResponseEntity.notFound();
    }
}
