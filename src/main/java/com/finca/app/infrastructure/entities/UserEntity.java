package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table (name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    private String correo;

    @Column(unique = true)
    private String username;
    private String contrasena;
    private Boolean activo;



    //Necesito el model de rol para poder trabajarlo en la tabla,
    //ya qeue tiene relacion uno a muchos con User


}
