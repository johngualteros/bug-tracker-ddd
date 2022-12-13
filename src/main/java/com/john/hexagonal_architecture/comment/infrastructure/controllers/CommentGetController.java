package com.john.hexagonal_architecture.comment.infrastructure.controllers;

import com.john.hexagonal_architecture.comment.application.CommentRepository;
import com.john.hexagonal_architecture.comment.infrastructure.CommentEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class CommentGetController {

    private final CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<CommentEntity> findAllComments() {
        return commentRepository.findAll();
    }

}
