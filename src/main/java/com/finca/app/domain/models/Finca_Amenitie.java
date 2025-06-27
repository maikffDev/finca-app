package com.finca.app.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Finca_Amenitie {

    private Long id;
    private Finca finca;
    private Amenitie amenitie;
}
