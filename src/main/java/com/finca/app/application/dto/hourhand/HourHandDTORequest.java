package com.finca.app.application.dto.hourhand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HourHandDTORequest {
    private Long hourHand;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

}
