package com.john.hexagonal_architecture.bug.infrastructure;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.john.hexagonal_architecture.bug.domain.IdGenerator;
import com.john.hexagonal_architecture.category.infrastructure.CategoryEntity;
import com.john.hexagonal_architecture.team.infrastructure.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "category_id")
    private CategoryEntity category;

}
