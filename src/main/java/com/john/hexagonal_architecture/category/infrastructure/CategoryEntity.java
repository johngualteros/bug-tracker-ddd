package com.john.hexagonal_architecture.category.infrastructure;

import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")

public class CategoryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long   id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String color;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    /*
    CascadeType.MERGE: propagates the merge operation from a parent to a child entity.

    FetchType.EAGER : fetch immediately
     */
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "team_id")
    private TeamEntity team;

}
