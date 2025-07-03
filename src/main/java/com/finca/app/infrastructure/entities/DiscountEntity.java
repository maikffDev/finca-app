package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "discount_entity")
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false,nullable=false)
    private String name;

    @Column(name="discount_percentage",nullable=false)
    private Double discountPercentage;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserDiscountEntity> userDiscounts = new ArrayList<>();
}
