package com.john.hexagonal_architecture.category.application;

import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
