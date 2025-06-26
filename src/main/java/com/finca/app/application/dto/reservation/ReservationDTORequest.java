package com.finca.app.application.dto.reservation;

import com.finca.app.domain.models.Horario;
import com.finca.app.domain.models.TypeOfSeason;
import com.finca.app.domain.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ReservationDTORequest {

    @NotNull(message ="reservation is required. An ID must be provided.")
    private Long reservationID;

    @NotNull(message = "fincaHorario is required. An ID must be provided.")
    private Horario fincaHorarioID;

    @NotNull(message = "User is required. An ID must be provided.")
    private Usuario userID;

    @NotNull(message = "TypeOfSeason is required. An ID must be provided.")
    private TypeOfSeason typeOfSeason;

    private Boolean on = true;

    @NotBlank(message = "Expiration is required. An ID must be provided.")
    private Date expiration;
}
