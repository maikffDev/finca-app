package com.finca.app.application.dto.reservation;

import com.finca.app.application.dto.FincaHourHnad.FincaHourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.domain.models.User;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ReservationDTORequest2 {

    @NotNull(message = "fincaHorario is required. An ID must be provided.")
    private Long fincaID;

    @NotNull(message = "User is required. An ID must be provided.")
    private Long userID;

    @NotNull(message = "HourdHands is required. An ID must be provided.")
    private List<FincaHourHandDTORequest> HourdHands;

}
