package com.john.hexagonal_architecture.bug.infrastructure;

import com.john.hexagonal_architecture.bug.domain.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bug")

public class BugEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long         id;


    @Column(nullable = false)
    private String       title;

    @Column(nullable = false)
    private String       status;

    @Column(nullable = false)
    private Long         priority;

    @Column(nullable = false)
    private String       date;

}
