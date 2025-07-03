package com.finca.app.application.services.schedule.impl;

import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.schedule.CreateScheduleUseCase;
import com.finca.app.domain.ports.in.schedule.DeleteScheduleUseCase;
import com.finca.app.domain.ports.in.schedule.FindScheduleUseCase;
import com.finca.app.domain.ports.in.schedule.UpdateScheduleUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleModelService implements CreateScheduleUseCase, DeleteScheduleUseCase, FindScheduleUseCase, UpdateScheduleUseCase {

    private final CreateScheduleUseCase createScheduleUseCase;
    private final DeleteScheduleUseCase deleteScheduleUseCase;
    private final UpdateScheduleUseCase updateScheduleUseCase;
    private final FindScheduleUseCase findScheduleUseCase;

    public ScheduleModelService(CreateScheduleUseCase createScheduleUseCase, DeleteScheduleUseCase deleteScheduleUseCase, UpdateScheduleUseCase updateScheduleUseCase, FindScheduleUseCase findScheduleUseCase) {
        this.createScheduleUseCase = createScheduleUseCase;
        this.deleteScheduleUseCase = deleteScheduleUseCase;
        this.updateScheduleUseCase = updateScheduleUseCase;
        this.findScheduleUseCase = findScheduleUseCase;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return createScheduleUseCase.create(schedule);
    }

    @Override
    public Boolean delete(Long id) {
        return deleteScheduleUseCase.delete(id);
    }

    @Override
    public Schedule logicalDeletion(Schedule schedule) {
        return deleteScheduleUseCase.logicalDeletion(schedule); // lógica definida por vos
    }

    @Override
    public List<Schedule> getAll() {
        return findScheduleUseCase.getAll();
    }

    @Override
    public Optional<Schedule> getById(Long id) {
        return findScheduleUseCase.getById(id);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return updateScheduleUseCase.update(schedule);
    }


}