package com.finca.app.domain.models;

import com.finca.app.infrastructure.entities.StateHistoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {
    private Long reservationID;
    private List<Finca_HourHand> fincaHourHand;
    private User userID;
    private Boolean on;
    private LocalDate expiration;
    private Ticket ticket;
    private List<StateHistoryEntity>  states;
    private BigDecimal totalCost;
}
