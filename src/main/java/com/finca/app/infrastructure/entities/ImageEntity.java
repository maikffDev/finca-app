package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "image_entity")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private FincaEntity finca;

    @Column(name = "url_image")
    private String urlImage;
}
