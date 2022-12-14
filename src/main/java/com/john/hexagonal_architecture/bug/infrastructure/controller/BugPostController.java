package com.john.hexagonal_architecture.bug.infrastructure.controller;

import com.john.hexagonal_architecture.bug.application.BugRepository;
import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class BugPostController {

    private final BugRepository bugRepository;

    @PostMapping("/bugs")
    public ResponseEntity<BugEntity> saveBug(@RequestBody BugEntity bugEntity){

        BugEntity bug = bugRepository.save(bugEntity);

        return ResponseEntity.status(200).body(bug);

    }

}
