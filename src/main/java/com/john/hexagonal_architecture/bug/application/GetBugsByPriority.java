package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service

public class GetBugsByPriority {

    private final BugRepository bugRepository;

    public List<BugEntity> getAllsBugsByPriority(Long priority){

        List<BugEntity> bugs = bugRepository.findAll();

        List<BugEntity> bugsResult = filterBugs(bugs, priority);

        return bugsResult;

    }

    private List<BugEntity> filterBugs(List<BugEntity> bugs, Long priority){

        List<BugEntity> bugsFilteredByPriority = new ArrayList<>();

        bugs.stream().filter(bug -> {
            if(Objects.equals(bug.getPriority(), priority)){
                bugsFilteredByPriority.add(bug);
            }
            return false;
        });

        return bugsFilteredByPriority;

    }

}
