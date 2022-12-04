package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetUsersNotLikeEmailGmail extends JpaRepository<UserEntity, Long> {

    @Modifying
    @Query(value="SELECT * FROM users u WHERE u.email NOT LIKE '%gmail%'", nativeQuery = true)
    List<UserEntity> getAllUserWithNotGmailEmail();

}
