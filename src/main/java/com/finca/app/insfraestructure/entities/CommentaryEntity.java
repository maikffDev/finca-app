package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;

@Entity
public class CommentaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private FincaEntity finca;

}
