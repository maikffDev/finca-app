package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaSchedule {
    private Long id;
    private Schedule schedule;
    private Finca finca;
    private Boolean enabled;
}
