package com.john.hexagonal_architecture.team.infrastructure.controllers;

import com.john.hexagonal_architecture.team.application.TeamRepository;
import com.john.hexagonal_architecture.team.application.UpdateTeam;
import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class TeamPutController {

    private final TeamRepository teamRepository;

    private final UpdateTeam     updateTeam;

    @PutMapping("/teams/{id}")
    public TeamEntity updateTeam(@PathVariable Long id, @RequestBody TeamEntity teamEntity){

        Optional<TeamEntity> teamUpdated = updateTeam.updateTeamAndFind(id, teamEntity);

        if(teamUpdated.isEmpty()) return null;

        TeamEntity teamForSave     = teamUpdated.get();

        teamRepository.save(teamForSave);

        return teamForSave;

    }

}
