package com.finca.app.application.dto.hourhand;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class HourHandDTOResponse {
    private Long HourHandID;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;


}
