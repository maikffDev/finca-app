package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "FincaSchedule", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fincaId", "scheduleId"})
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaScheduleEntity {

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
