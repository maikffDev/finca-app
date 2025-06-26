package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
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

}
