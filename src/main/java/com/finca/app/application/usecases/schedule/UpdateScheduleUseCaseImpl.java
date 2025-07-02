package com.finca.app.application.usecases.schedule;

import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.schedule.UpdateScheduleUseCase;
import com.finca.app.domain.ports.out.ScheduleModelPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateScheduleUseCaseImpl implements UpdateScheduleUseCase{
    private final ScheduleModelPort scheduleModelPort;

    public UpdateScheduleUseCaseImpl(ScheduleModelPort scheduleModelPort){
        this.scheduleModelPort = scheduleModelPort;
    }

    @Override
    public Schedule update(Schedule schedule){
        return scheduleModelPort.update(schedule);
    }
}
