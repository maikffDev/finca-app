package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique=false,nullable=false)
    private String username;


    @Column(unique = false,nullable=false)
    private String correo;

    @Column(nullable=false)
    private String contrasena;


    @Column(name="int_fallidos_ingreso")
    private int intFallidosIngreso;

    private boolean activo;

    @ManyToMany
    @JoinTable(
            name = "usuario_role",  
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity>rolesId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentaryEntity> comments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<ReservationEntity> reservationEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentDetailsEntity> paymentDetails = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserDiscountEntity> userDiscounts = new ArrayList<>();

}