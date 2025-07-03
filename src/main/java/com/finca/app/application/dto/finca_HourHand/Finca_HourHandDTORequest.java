package com.finca.app.application.dto.finca_HourHand;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Finca_HourHandDTORequest {
    @NotNull(message = "Finca ID is required.")
    private Long fincaId;

    @NotNull(message = "Hour Hand ID is required.")
    private Long hourHandId;

    @NotNull(message = "Hourly rate is required.")
    @PositiveOrZero(message = "Hourly rate must be a positive number or zero.")
    private Double hourlyRate;

    private Boolean reserved;
}
