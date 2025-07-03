package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Finca_HourHand")
public class Finca_HourHandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "finca_id", nullable = false)
    private Long fincaId;

    @Column(name = "hour_hand_id", nullable = false)
    private Long hourHandId;

    @Column(name = "hour_hand_start_time")
    private String hourHandStartTime;

    @Column(name = "hour_hand_end_time")
    private String hourHandEndTime;

}
