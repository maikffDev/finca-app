package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FincaHourHand")
public class FincaHourHandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fincaID", nullable = false)
    private FincaEntity finca;

    @ManyToOne
    @JoinColumn(name = "horarioID", nullable = false)
    private ScheduleEntity scheduleEntity;

    private boolean reserved;

}
