package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    private int usuarioId;
    private String nombre;
    private String correo;
    private String contrasena;
    private int intFallidosIngreso;
    private int activo;
    private boolean rolId;
}
