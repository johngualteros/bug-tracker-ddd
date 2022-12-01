package com.john.hexagonal_architecture.team.infrastructure.controllers;

import com.john.hexagonal_architecture.team.application.TeamRepository;
import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class TeamPostController {

    private final TeamRepository teamRepository;

    @PostMapping("/teams")
    public ResponseEntity<TeamEntity> saveTeam(@RequestBody TeamEntity team){

        TeamEntity teamSaved = teamRepository.save(team);

        return ResponseEntity.status(200).body(teamSaved);

    }

}
