package com.finca.app.application.usecases.fincaSchedule;

import com.finca.app.application.usecases.schedule.UpdateScheduleUseCaseImpl;
import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.ports.in.fincaSchedule.UpdateFincaScheduleUseCase;
import com.finca.app.domain.ports.in.schedule.UpdateScheduleUseCase;
import com.finca.app.domain.ports.out.FincaScheduleModelPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateFincaScheduleUseCaseImpl implements UpdateFincaScheduleUseCase {

    private final FincaScheduleModelPort fincaScheduleModelPort;

    public UpdateFincaScheduleUseCaseImpl(FincaScheduleModelPort fincaScheduleModelPort){
        this.fincaScheduleModelPort = fincaScheduleModelPort;
    }

    @Override
    public FincaSchedule update(FincaSchedule fincaSchedule){
        return fincaScheduleModelPort.update(fincaSchedule);
    }
}
