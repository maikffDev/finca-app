package com.finca.app.application.dto.finca;

import com.finca.app.application.dto.schedule.ScheduleDTOResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaDTOResponseSimplified {
    private Long id;
    private Long userId;
    private String name;
    private String location;
    private String description;
    private String pricePerHour;
    private Boolean active;
}
