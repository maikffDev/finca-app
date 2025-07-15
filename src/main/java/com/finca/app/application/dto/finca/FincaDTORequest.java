package com.finca.app.application.dto.finca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaDTORequest {
    @NotBlank(message= "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Ubication cannot be empty.")
    private String ubication;

    @NotNull
    private double pricePerHour;

    @NotNull
    private Long userId;

    private Boolean active = true;
}
