package com.john.hexagonal_architecture.user.infrastructure;

import javax.persistence.*;

@Entity
@Table(name = "users")

public final class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String password;

}
