package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;
    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FincaScheduleEntity> fincaSchedules;

}
