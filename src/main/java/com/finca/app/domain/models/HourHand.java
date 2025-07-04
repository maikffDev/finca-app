package com.finca.app.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HourHand {
    private Long HourHandID;
    private LocalDate date;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
}
