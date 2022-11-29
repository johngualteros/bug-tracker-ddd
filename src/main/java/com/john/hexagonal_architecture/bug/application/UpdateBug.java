package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UpdateBug {

    private final GetOneBugById getOneBugById;

    public Optional<BugEntity> updateBug(Long id, BugEntity bug){

        Optional<BugEntity> bugFound = getOneBugById.getOneBug(id);

        if(bugFound.isEmpty()) return Optional.empty();

        bugFound.get().setTitle(bug.getTitle());

        bugFound.get().setStatus(bug.getStatus());

        bugFound.get().setPriority(bug.getPriority());

        return bugFound;
    }

}
