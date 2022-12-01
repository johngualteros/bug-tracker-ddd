package com.john.hexagonal_architecture.team.infrastructure.controllers;


import com.john.hexagonal_architecture.team.application.GetOneTeamById;
import com.john.hexagonal_architecture.team.application.TeamRepository;
import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class TeamGetController {

    private final TeamRepository teamRepository;

    private final GetOneTeamById getOneTeamById;


    @GetMapping("/teams")
    public List<TeamEntity> getAllTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Optional<TeamEntity> getOneTeam(@PathVariable Long id){
        return getOneTeamById.getOneTeamByIdIfExists(id);
    }

}
