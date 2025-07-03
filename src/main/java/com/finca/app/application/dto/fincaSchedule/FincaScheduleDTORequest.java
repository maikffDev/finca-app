package com.finca.app.application.dto.fincaSchedule;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaScheduleDTORequest {

    @NotNull(message = "Finca is required. An ID must be provided.")
    private Long fincaId;

    @NotNull(message = "Schedule is required. An ID must be provided.")
    private Long scheduleId;

    private Boolean enabled = true;
}
