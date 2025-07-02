package com.finca.app.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
    private Long ScheduleID;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
