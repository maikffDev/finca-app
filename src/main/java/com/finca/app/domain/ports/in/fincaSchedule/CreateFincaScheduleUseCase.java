package com.finca.app.domain.ports.in.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;

public interface CreateFincaScheduleUseCase {
    FincaSchedule create(FincaSchedule fincaSchedule);
}
