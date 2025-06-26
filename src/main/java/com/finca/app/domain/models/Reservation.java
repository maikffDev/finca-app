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
    private HourHand fincaHourHandID;
    private Usuario userID;
    private TypeOfSeason typeOfSeasonID;
    private Boolean on;
    private Date expiration;
}
