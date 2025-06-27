package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TypeOfSeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "typeOfSeason")
    private List<ReservationEntity> reservations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "discount_id", nullable = false)
    private DiscountEntity discountEntity;

    @OneToOne
    @JoinColumn(name = "season_id", nullable = false)
    private SeasonEntity seasonEntity;

}
