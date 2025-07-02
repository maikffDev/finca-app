package com.finca.app.application.usecases.schedule;

import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.schedule.FindScheduleUseCase;
import com.finca.app.domain.ports.out.ScheduleModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindScheduleUseCaseImpl implements FindScheduleUseCase {
    private final ScheduleModelPort scheduleModelPort;

    public FindScheduleUseCaseImpl(ScheduleModelPort scheduleModelPort){
        this.scheduleModelPort = scheduleModelPort;
    }

    @Override
    public List<Schedule> getAll(){
        return scheduleModelPort.getAll();
    }

    @Override
    public Optional<Schedule> getById(Long id){
        return scheduleModelPort.findById(id);
    }
}
