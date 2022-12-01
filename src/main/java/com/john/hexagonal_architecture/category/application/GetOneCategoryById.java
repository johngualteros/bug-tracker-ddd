package com.john.hexagonal_architecture.category.application;

import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class GetOneCategoryById {

    private final CategoryRepository categoryRepository;


    public Optional<CategoryEntity> getOneCategoryIfExists(Long id){

        Optional<CategoryEntity> categoryFound = categoryRepository.findById(id);

        if(categoryFound.isEmpty()){
            return Optional.empty();
        }

        return categoryFound;

    }

}
