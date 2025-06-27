package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;

public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private FincaEntity finca;

    private String urlImage;
}
