package com.finca.app.domain.ports.in.schedule;

import com.finca.app.domain.models.Schedule;

public interface DeleteScheduleUseCase {
    Boolean delete(Long id);

    Schedule logicalDeletion(Schedule schedule);
}
