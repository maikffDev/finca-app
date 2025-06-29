package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class FincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String address;

    private double pricePerHour;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;

    private String description;

    private boolean active;

    @OneToMany(mappedBy = "finca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FincaHourHandEntity> availableHours;

    @ManyToMany
    @JoinTable(
            name = "Amenitie_FINCA",
            joinColumns = @JoinColumn(name = "fincaID"),
            inverseJoinColumns = @JoinColumn(name = "amenitieID")
    )
    private Set<AmenitieEntity> amenities;

    @OneToMany(mappedBy = "finca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageEntity> images = new ArrayList<>();


}
