package com.finca.app.application.dto.amenitie;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AmenitieDTORequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo de amenitie no puede estar vacío")
    private String tipoDeAmenitie;
}