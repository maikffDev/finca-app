package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "finca_hour_hand_entity")
public class FincaHourHandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "finca_id", nullable = false)
    private FincaEntity finca;

    @ManyToOne
    @JoinColumn(name = "hour_hand_id", nullable = false)
    private HourHandEntity hourHandEntity;

    private boolean reserved;

    @Column(name = "price_per_hour")
    private double pricePerHour;

    @Override
    public String toString() {
        return "FincaHourHandEntity{" +
                "id=" + id +
                ", finca=" + finca +
                ", hourHandEntity=" + hourHandEntity +
                ", reserved=" + reserved +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
