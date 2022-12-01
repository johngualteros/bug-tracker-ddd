package com.john.hexagonal_architecture.category.application;

import com.john.hexagonal_architecture.bug.application.GetOneBugById;
import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UpdateCategory {

    private final GetOneCategoryById getOneCategoryById;

    public Optional<CategoryEntity> updateCategoryAndFind(Long id, CategoryEntity category){

        Optional<CategoryEntity> categoryFound = getOneCategoryById.getOneCategoryIfExists(id);

        if(categoryFound.isEmpty()) return Optional.empty();

        categoryFound.get().setName(category.getName());

        categoryFound.get().setDescription(category.getDescription());

        categoryFound.get().setColor(category.getColor());

        return categoryFound;
    }

}
