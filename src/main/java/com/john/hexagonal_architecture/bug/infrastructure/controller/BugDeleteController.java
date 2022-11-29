package com.john.hexagonal_architecture.bug.infrastructure.controller;

import com.john.hexagonal_architecture.bug.application.BugRepository;
import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class BugDeleteController {

    private final BugRepository bugRepository;

    @DeleteMapping("/bugs/{id}")
    public ResponseEntity<?> deleteBugById(@PathVariable Long id) {

        Optional<BugEntity> bug = bugRepository.findById(id);

        bugRepository.deleteById(id);

        return ResponseEntity.status(202).body(bug);

    }
}
