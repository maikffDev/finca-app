package com.finca.app.application.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScheduleDTORequest {
    @NotNull(message = "Schedule is required. An ID must be provided.")
    private Long scheduleId;
    @NotBlank(message = "Date cannot be empty.")
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

}
