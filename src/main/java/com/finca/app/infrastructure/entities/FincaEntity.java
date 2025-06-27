package com.finca.app.infrastructure.entities;

import com.finca.app.domain.models.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "finca")
public class FincaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String ubication;

    private double pricePerHour;

    private String description;

    private boolean active;

    @OneToMany(mappedBy = "finca")
    private List<Schedule> availableSchedules;
}
