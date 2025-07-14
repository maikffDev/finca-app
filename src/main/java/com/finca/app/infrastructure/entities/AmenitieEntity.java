package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "amenitie_entity")
public class AmenitieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column(name= "tipo_De_Amenitie")
    private String tipoDeAmenitie;

    @ManyToMany(mappedBy = "amenities")
    private Set<FincaEntity> fincas;
}
