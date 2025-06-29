package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique=true,nullable=false)
    private String nombre;

    @Column(unique = true,nullable=false)
    private String correo;

    @Column(nullable=false)
    private String contrasena;

    private int intFallidosIngreso;

    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RoleEntity rolId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentaryEntity> comments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<ReservationEntity> reservationEntities = new ArrayList<>();

}
