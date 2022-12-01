package com.john.hexagonal_architecture.team.application;

import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
