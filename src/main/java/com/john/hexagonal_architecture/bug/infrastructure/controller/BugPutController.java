package com.john.hexagonal_architecture.bug.infrastructure.controller;

import com.john.hexagonal_architecture.bug.application.BugRepository;
import com.john.hexagonal_architecture.bug.application.UpdateBug;
import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class BugPutController {

    private final BugRepository bugRepository;

    private final UpdateBug     updateBugService;

    @PutMapping("/bugs/{id}")
    public BugEntity updateBugByIdAndUpdate(@PathVariable Long id, @RequestBody BugEntity bugEntity) {

        Optional<BugEntity> bugUpdated = updateBugService.updateBug(id, bugEntity);

        if (bugUpdated.isPresent()){

            BugEntity castedEntityBug  = BugEntity.class.cast(bugUpdated);

            return bugRepository.save(castedEntityBug);

        }

        return null;
    }

}
