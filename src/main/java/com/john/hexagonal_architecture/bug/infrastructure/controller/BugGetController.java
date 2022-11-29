package com.john.hexagonal_architecture.bug.infrastructure.controller;

import com.john.hexagonal_architecture.bug.application.*;
import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/")

public class BugGetController {

    private final BugRepository     bugRepository;

    private final GetOneBugById     getOneBugById;

    private final GetBugsByPriority getBugsByPriority;

    private final GetInProgressBugs getInProgressBugs;

    private final GetOpenBugs       getOpenBugs;

    private final GetReviewingBugs  getReviewingBugs;

    private final GetSolvedBugs     getSolvedBugs;

    @GetMapping("/bugs")
    public List<BugEntity> getAllBugs(){

        return bugRepository.findAll();

    }

    @GetMapping("/bugs/{id}")
    public Optional<BugEntity> getOneBugById(@PathVariable Long id){

        Optional<BugEntity> bugFound = getOneBugById.getOneBug(id);

        if(bugFound.isEmpty()) return null;

        return bugFound;

    }

    @GetMapping("/bugs/open")
    public List<BugEntity> getBugsByOpenStatus(){

        return getOpenBugs.getAllBugsByStatusOpen();

    }

    @GetMapping("/bugs/progress")
    public List<BugEntity> getBugsByProgressStatus(){

        return getInProgressBugs.getBugsInProgressStatus();

    }

    @GetMapping("/bugs/reviewing")
    public List<BugEntity> getBugsByReviewingStatus(){

        return getReviewingBugs.getBugsByReviewingStatus();

    }

    @GetMapping("/bugs/solved")
    public List<BugEntity> getBugsBySolvedStatus(){

        return getSolvedBugs.getBugsByStatusSolved();

    }

    @GetMapping("/bugs/priority/{priority}")
    public List<BugEntity> getBugsPriority(@PathVariable Long priority){

        return getBugsByPriority.getAllsBugsByPriority(priority);

    }



}
