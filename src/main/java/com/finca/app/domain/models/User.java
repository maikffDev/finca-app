package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String correo;
    private String contrasena;
    private int intFallidosIngreso;
    private Boolean activo;
    private List<Role>roles;
    private List<PaymentDetails> paymentDetailsList;
}
