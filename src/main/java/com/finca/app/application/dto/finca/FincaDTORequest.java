package com.finca.app.application.dto.finca;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "PricePerHour cannot be empty.")
    private String pricePerHour;

    private Boolean active = true;
}
