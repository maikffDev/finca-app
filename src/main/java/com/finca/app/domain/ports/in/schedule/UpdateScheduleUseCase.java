package com.finca.app.domain.ports.in.schedule;

import com.finca.app.domain.models.Schedule;

public interface UpdateScheduleUseCase {
    Schedule update(Schedule schedule);
}
