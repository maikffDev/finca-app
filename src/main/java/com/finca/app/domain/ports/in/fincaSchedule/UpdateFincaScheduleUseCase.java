package com.finca.app.domain.ports.in.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;

public interface UpdateFincaScheduleUseCase {
    FincaSchedule update(FincaSchedule fincaSchedule);
}
