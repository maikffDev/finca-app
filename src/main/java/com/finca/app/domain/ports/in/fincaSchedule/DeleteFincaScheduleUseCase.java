package com.finca.app.domain.ports.in.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;

public interface DeleteFincaScheduleUseCase {
    Boolean delete(Long id);
    FincaSchedule logicalDeletion(FincaSchedule fincaSchedule);
}
