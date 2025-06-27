package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AmenitieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private String nombre;

    @Column(unique = true,nullable=false)
    private String tipoDeAmenitie;

    @ManyToMany(mappedBy = "amenities")
    private Set<FincaEntity> fincas;
}
