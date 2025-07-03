package com.finca.app.application.dto.fincaSchedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaScheduleDTOResponse {
    private Long id;
    private String fincaId;
    private String scheduleId;
    private Boolean enabled;
}
