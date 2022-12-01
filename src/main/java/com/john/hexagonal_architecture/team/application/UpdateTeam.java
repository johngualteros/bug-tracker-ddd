package com.john.hexagonal_architecture.team.application;

import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UpdateTeam {

    private final GetOneTeamById getOneTeamById;

    public Optional<TeamEntity> updateTeamAndFind(Long id, TeamEntity team){

        Optional<TeamEntity> teamFound = getOneTeamById.getOneTeamByIdIfExists(id);

        if(teamFound.isEmpty()) return Optional.empty();

        teamFound.get().setName(team.getName());

        teamFound.get().setAccess_token(team.getAccess_token());

        teamFound.get().setColor(team.getColor());

        return teamFound;
    }

}
