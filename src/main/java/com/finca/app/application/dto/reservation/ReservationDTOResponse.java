package com.finca.app.application.dto.reservation;


import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.models.TypeOfSeason;
import com.finca.app.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTOResponse {
    private Long reservationID;
    private HourHand fincaHorarioID;
    private User userID;
    private Boolean on;
    private Date expiration;
    private BigDecimal totalCost;
}
