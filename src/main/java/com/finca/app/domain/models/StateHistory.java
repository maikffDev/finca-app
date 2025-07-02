package com.finca.app.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StateHistory {
    private Long stateHistoryId;
    private State stateId;
    private Reservation reservationId;
    private LocalDate fecha;
}
