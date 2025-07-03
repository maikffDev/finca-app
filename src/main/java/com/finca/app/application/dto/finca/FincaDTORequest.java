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

    @NotNull(message = "User is required. An ID must be provided.")
    private Long userId;

    @NotBlank(message= "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Ubication cannot be empty.")
    private String ubication;

    @NotBlank(message = "PricePerHour cannot be empty.")
    private String pricePerHour;

    private Boolean active = true;
}
