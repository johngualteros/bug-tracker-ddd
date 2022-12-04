package com.john.hexagonal_architecture.category.infrastructure.controllers;

import com.john.hexagonal_architecture.bug.application.BugRepository;
import com.john.hexagonal_architecture.category.application.CategoryRepository;
import com.john.hexagonal_architecture.category.application.UpdateCategory;
import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class CategoryPutController {

    private final CategoryRepository categoryRepository;

    private final UpdateCategory updateCategory;

    @PutMapping("/categories/{id}")
    public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity category){

        Optional<CategoryEntity> categoryUpdated = updateCategory.updateCategoryAndFind(id,category);

        if(categoryUpdated.isEmpty()) return null;

        CategoryEntity categoryForSave     = categoryUpdated.get();

        categoryRepository.save(categoryForSave);

        return categoryForSave;

    }

}
