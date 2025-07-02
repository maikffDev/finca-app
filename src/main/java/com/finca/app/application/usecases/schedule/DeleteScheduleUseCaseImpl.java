package com.finca.app.application.usecases.schedule;

import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.schedule.DeleteScheduleUseCase;
import com.finca.app.domain.ports.out.ScheduleModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleUseCaseImpl implements DeleteScheduleUseCase {
    private final ScheduleModelPort scheduleModelPort;

    public DeleteScheduleUseCaseImpl(ScheduleModelPort scheduleModelPort){
        this.scheduleModelPort = scheduleModelPort;
    }

    @Override
    public Boolean delete(Long id) {
        return scheduleModelPort.delete(id);
    }

    @Override
    public Schedule logicalDeletion(Schedule schedule) {
        return null;
    }
}
