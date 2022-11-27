package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public final class GetOpenBugs {

    private final BugRepository bugRepository;

    public List<BugEntity> getAllBugsByStatusOpen(){

        return bugRepository.getBugsByOpenStatus();

    }

}
