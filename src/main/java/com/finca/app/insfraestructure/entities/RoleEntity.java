package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private String role;
}
