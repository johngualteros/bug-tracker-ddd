package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class GetReviewingBugs {

    private final BugRepository bugRepository;

    public List<BugEntity> getBugsByReviewingStatus(){

        return bugRepository.getBugsByReviewingStatus();

    }
}
