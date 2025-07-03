package com.finca.app.application.usecases.fincaSchedule;

import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.ports.in.fincaSchedule.DeleteFincaScheduleUseCase;
import com.finca.app.domain.ports.out.FincaScheduleModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteFincaScheduleUseCaseImpl implements DeleteFincaScheduleUseCase {

    private final FincaScheduleModelPort fincaScheduleModelPort;

    public DeleteFincaScheduleUseCaseImpl(FincaScheduleModelPort fincaScheduleModelPort){
        this.fincaScheduleModelPort = fincaScheduleModelPort;
    }

    @Override
    public Boolean delete(Long id){
        return fincaScheduleModelPort.delete(id);
    }

    @Override
    public FincaSchedule logicalDeletion(FincaSchedule fincaSchedule){
        return fincaScheduleModelPort.logicalDeletion(fincaSchedule);
    }
}
