package com.john.hexagonal_architecture.team.infrastructure.controllers;


import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import com.john.hexagonal_architecture.team.application.GetOneTeamById;
import com.john.hexagonal_architecture.team.application.TeamRepository;
import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@AllArgsConstructor
@RequestMapping("/api/v1/")

public class TeamDeleteController {

    private final TeamRepository teamRepository;

    private final GetOneTeamById getOneTeamById;

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeamById(@PathVariable Long id){

        Optional<TeamEntity> teamFound = getOneTeamById.getOneTeamByIdIfExists(id);

        if(teamFound.isPresent()){

            teamRepository.deleteById(id);

            return ResponseEntity.status(202).body(teamFound);

        }

        return (ResponseEntity<?>) ResponseEntity.notFound();
    }

}
