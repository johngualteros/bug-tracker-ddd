package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class GetOneBugById {

    private final BugRepository bugRepository;

    public Optional<BugEntity> getOneBugById(Long id){

        Optional<BugEntity> bug = bugRepository.findById(id);

        if (bug.isEmpty()){
            return null;
        }

        return bug;

    }
}
