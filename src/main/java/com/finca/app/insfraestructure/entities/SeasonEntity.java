package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

   @ManyToOne
   @JoinColumn(name = "typeOfSeason_id", nullable = false)
   private TypeOfSeasonEntity typeOfSeasonEntity;

}
