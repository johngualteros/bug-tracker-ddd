package com.john.hexagonal_architecture.team.application;

import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class GetOneTeamById {

    private final TeamRepository teamRepository;

    public Optional<TeamEntity> getOneTeamByIdIfExists(Long id){

        Optional<TeamEntity> teamFound = teamRepository.findById(id);

        if(teamFound.isEmpty()) return Optional.empty();

        return teamFound;

    }

}
