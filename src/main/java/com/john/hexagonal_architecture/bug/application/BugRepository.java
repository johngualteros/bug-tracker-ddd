package com.john.hexagonal_architecture.bug.application;

import com.john.hexagonal_architecture.bug.infrastructure.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BugRepository extends JpaRepository<BugEntity, Long> {

    @Query(name = "SELECT b FROM bug b WHERE b.status = 'Open'", nativeQuery = true)
    List<BugEntity> getBugsByOpenStatus();

    @Query(name = "SELECT b FROM bug b WHERE b.status = 'In Progress'", nativeQuery = true)
    List<BugEntity> getBugsByInProgressStatus();

    @Query(name = "SELECT b FROM bug b WHERE b.status = 'Reviewing'", nativeQuery = true)
    List<BugEntity> getBugsByReviewingStatus();

    @Query(name = "SELECT b FROM bug b WHERE b.status = 'Solved'", nativeQuery = true)
    List<BugEntity> getBugsBySolvedStatus();



}
