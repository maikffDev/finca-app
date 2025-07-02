package com.finca.app.application.dto.schedule;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScheduleDTOResponse {
    private Long scheduleID;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;


}
