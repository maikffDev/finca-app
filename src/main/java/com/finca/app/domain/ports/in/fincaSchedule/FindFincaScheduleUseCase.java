package com.finca.app.domain.ports.in.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;

import java.util.List;
import java.util.Optional;

public interface FindFincaScheduleUseCase {
    Optional<FincaSchedule> getById(Long id);

    List<FincaSchedule> getAll();

    List<Schedule> getSchedulesByFincaId(Long fincaId);
}
