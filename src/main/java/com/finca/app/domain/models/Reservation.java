package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    private Long reservationID;
    private Schedule fincaHorarioID;
    private User userID;
    private TypeOfSeason typeOfSeason;
    private Boolean on;
    private Date expiration;
    private Ticket ticket;
}
