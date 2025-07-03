package com.finca.app.application.usecases.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.in.fincaSchedule.FindFincaScheduleUseCase;
import com.finca.app.domain.ports.out.FincaScheduleModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindFincaScheduleUseCaseImpl implements FindFincaScheduleUseCase {

    private final FincaScheduleModelPort fincaScheduleModelPort;

    public FindFincaScheduleUseCaseImpl(FincaScheduleModelPort fincaScheduleModelPort){
        this.fincaScheduleModelPort = fincaScheduleModelPort;
    }

    @Override
    public Optional<FincaSchedule> getById(Long id){
        return fincaScheduleModelPort.findById(id);
    }

    @Override
    public List<FincaSchedule> getAll(){
        return fincaScheduleModelPort.findAll();
    }

    @Override
    public List<Schedule> getSchedulesByFincaId(Long fincaId){
        return fincaScheduleModelPort.getSchedulesByFincaId(fincaId);
    }
}
