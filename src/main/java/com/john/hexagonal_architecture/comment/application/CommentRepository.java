package com.john.hexagonal_architecture.comment.application;

import com.john.hexagonal_architecture.comment.infrastructure.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
