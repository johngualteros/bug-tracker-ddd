package com.john.hexagonal_architecture.team.infrastructure;

import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import com.john.hexagonal_architecture.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")

public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    @Column
    private String name;

    @Column
    private String access_token;

    @Column
    private String color;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "user_id")
    private UserEntity user;
}
