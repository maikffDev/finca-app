package com.finca.app.application.usecases.schedule;

import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.schedule.CreateScheduleUseCase;
import com.finca.app.domain.ports.out.ScheduleModelPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateScheduleUseCaseImpl implements CreateScheduleUseCase {
    private final ScheduleModelPort scheduleModelPort;

    public CreateScheduleUseCaseImpl(ScheduleModelPort scheduleModelPort){this.scheduleModelPort = scheduleModelPort;}

    @Override
    public Schedule create(Schedule schedule) { return scheduleModelPort.save(schedule);}
}
