package com.finca.app.application.usecases.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.ports.in.fincaSchedule.CreateFincaScheduleUseCase;
import com.finca.app.domain.ports.out.FincaScheduleModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateFincaScheduleUseCaseImpl implements CreateFincaScheduleUseCase {

    private final FincaScheduleModelPort fincaScheduleModelPort;

    public CreateFincaScheduleUseCaseImpl(FincaScheduleModelPort fincaScheduleModelPort){
        this.fincaScheduleModelPort = fincaScheduleModelPort;
    }

    @Override
    public FincaSchedule create(FincaSchedule fincaSchedule){
        return fincaScheduleModelPort.save(fincaSchedule);
    }
}
