package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleModelPort {
    Schedule save(Schedule schedule);
    List<Schedule> getAll();
    Optional<Schedule> findById(Long id);
    Schedule update(Schedule schedule);
    Boolean delete(Long id);
    Schedule logicalDeletion(Schedule schedule);
}
