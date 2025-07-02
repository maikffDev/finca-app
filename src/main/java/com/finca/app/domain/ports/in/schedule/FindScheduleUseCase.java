package com.finca.app.domain.ports.in.schedule;

import com.finca.app.domain.models.Schedule;

import java.util.List;
import java.util.Optional;

public interface FindScheduleUseCase {
    List<Schedule> getAll();

    Optional<Schedule> getById(Long id);

}
