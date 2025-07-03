package com.finca.app.application.services.fincaSchedule.impl;

import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.fincaSchedule.CreateFincaScheduleUseCase;
import com.finca.app.domain.ports.in.fincaSchedule.DeleteFincaScheduleUseCase;
import com.finca.app.domain.ports.in.fincaSchedule.FindFincaScheduleUseCase;
import com.finca.app.domain.ports.in.fincaSchedule.UpdateFincaScheduleUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaScheduleModelService implements CreateFincaScheduleUseCase, DeleteFincaScheduleUseCase, UpdateFincaScheduleUseCase, FindFincaScheduleUseCase {

    private final CreateFincaScheduleUseCase createFincaScheduleUseCase;
    private final DeleteFincaScheduleUseCase deleteFincaScheduleUseCase;
    private final UpdateFincaScheduleUseCase updateFincaScheduleUseCase;
    private final FindFincaScheduleUseCase findFincaScheduleUseCase;

    public FincaScheduleModelService(CreateFincaScheduleUseCase createFincaScheduleUseCase, DeleteFincaScheduleUseCase deleteFincaScheduleUseCase, UpdateFincaScheduleUseCase updateFincaScheduleUseCase, FindFincaScheduleUseCase findFincaScheduleUseCase){
        this.createFincaScheduleUseCase = createFincaScheduleUseCase;
        this.deleteFincaScheduleUseCase = deleteFincaScheduleUseCase;
        this.updateFincaScheduleUseCase = updateFincaScheduleUseCase;
        this.findFincaScheduleUseCase = findFincaScheduleUseCase;
    }

    @Override
    public FincaSchedule create(FincaSchedule fincaSchedule){
        return createFincaScheduleUseCase.create(fincaSchedule);
    }

    @Override
    public Boolean delete(Long id){
        return deleteFincaScheduleUseCase.delete(id);
    }

    @Override
    public FincaSchedule logicalDeletion(FincaSchedule fincaSchedule){
        return deleteFincaScheduleUseCase.logicalDeletion(fincaSchedule);
    }

    @Override
    public Optional<FincaSchedule> getById(Long id){
        return findFincaScheduleUseCase.getById(id);
    }

    @Override
    public List<FincaSchedule> getAll(){
        return findFincaScheduleUseCase.getAll();
    }

    @Override
    public List<Schedule> getSchedulesByFincaId(Long fincaId){
        return findFincaScheduleUseCase.getSchedulesByFincaId(fincaId);
    }

    @Override
    public FincaSchedule update(FincaSchedule fincaSchedule){
        return updateFincaScheduleUseCase.update(fincaSchedule);
    }
}
