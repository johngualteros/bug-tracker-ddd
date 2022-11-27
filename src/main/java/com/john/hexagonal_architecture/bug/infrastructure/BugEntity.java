package com.john.hexagonal_architecture.bug.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bug")

public class BugEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long         id;


    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "bug_id", columnDefinition = "VARCHAR(255)")
    private UUID         bug_id;

    @Column(nullable = false)
    private String       title;

    @Column(nullable = false)
    private String       status;

    @Column(nullable = false)
    private Long         priority;

    @Column(nullable = false)
    private String       date;

}
