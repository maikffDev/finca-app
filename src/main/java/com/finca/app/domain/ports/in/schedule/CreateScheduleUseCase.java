package com.finca.app.domain.ports.in.schedule;

import com.finca.app.domain.models.Schedule;

public interface CreateScheduleUseCase {
    Schedule create(Schedule schedule);
}
