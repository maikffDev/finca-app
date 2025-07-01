package com.finca.app.application.dto.reservation;

import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.models.TypeOfSeason;
import com.finca.app.domain.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public class ReservationDTORequest {

    @NotNull(message ="reservation is required. An ID must be provided.")
    private Long reservationID;

    @NotNull(message = "fincaHorario is required. An ID must be provided.")
    private HourHand fincaHorarioID;

    @NotNull(message = "User is required. An ID must be provided.")
    private User userID;

    private Boolean on = true;

    @NotBlank(message = "Expiration is required. An ID must be provided.")
    private Date expiration;

    @NotNull(message = "An import is required")
    private BigDecimal totalCost;
}
