package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private String nombre;

    @Column(unique = true,nullable=false)
    private Double discountPercentage;
}
