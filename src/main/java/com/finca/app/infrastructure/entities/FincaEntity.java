package com.finca.app.infrastructure.entities;

import com.finca.app.domain.models.Schedule;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "finca_entity")
public class FincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String name;

    @Column(unique = false)
    private String ubication;

    @Column(name="price_per_hour")
    private double pricePerHour;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;

    private String description;

    private boolean active;

    @OneToMany(mappedBy = "finca")
    private List<FincaHourHandEntity> availableSchedules;

    @ManyToMany
    @JoinTable(
            name = "amenitie_finca",
            joinColumns = @JoinColumn(name = "finca_id"),
            inverseJoinColumns = @JoinColumn(name = "amenitie_id")
    )
    private Set<AmenitieEntity> amenities;

    @OneToMany(mappedBy = "finca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageEntity> images = new ArrayList<>();
}
