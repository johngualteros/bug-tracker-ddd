package com.john.hexagonal_architecture.comment.infrastructure.controllers;

import com.john.hexagonal_architecture.comment.application.CommentRepository;
import com.john.hexagonal_architecture.comment.infrastructure.CommentEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class CommentPost {

    private final CommentRepository commentRepository;

    @PostMapping("/comments")
    public CommentEntity saveComment(@RequestBody CommentEntity comment) {

        return commentRepository.save(comment);

    }

}
