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

        return filterBugs(bugs, priority);

    }

    private List<BugEntity> filterBugs(List<BugEntity> bugs, Long priority){

        List<BugEntity> bugsFilteredByPriority = new ArrayList<>();

        bugs.stream()
                .parallel()
                .filter(bug -> Objects.equals(bug.getPriority(), priority))
                .forEach(bugsFilteredByPriority::add);

        return bugsFilteredByPriority;

    }

}
