package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;

import java.util.List;
import java.util.Optional;

public interface FincaScheduleModelPort {
    FincaSchedule save(FincaSchedule fincaSchedule);

    List<FincaSchedule> findAll();

    Optional<FincaSchedule> findById(Long id);

    FincaSchedule update(FincaSchedule fincaSchedule);

    Boolean delete(Long id);

    FincaSchedule logicalDeletion(FincaSchedule fincaSchedule);

    List<Schedule> getSchedulesByFincaId(Long fincaId);
}
