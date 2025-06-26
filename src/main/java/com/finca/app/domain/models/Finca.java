package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Finca {

    private Long id;
    private String nombre;
    private String ubicacion;
    private double pricePerHour;
    private User user;
    private String descripccion;
    private boolean active;

}
