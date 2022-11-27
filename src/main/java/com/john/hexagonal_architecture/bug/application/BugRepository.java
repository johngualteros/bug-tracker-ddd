package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BugRepository extends JpaRepository<BugEntity, Long> {
}
