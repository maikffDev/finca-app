package com.finca.app.application.usecases.finca_HourHand;

import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.ports.in.finca_HourHand.DeleteFinca_HourHandUseCase;
import com.finca.app.domain.ports.out.Finca_HourHandModelPort;


public class DeleteFinca_HourHandUseCaseImpl implements DeleteFinca_HourHandUseCase {
    private final Finca_HourHandModelPort finca_HourHandModelPort;

    public DeleteFinca_HourHandUseCaseImpl(Finca_HourHandModelPort finca_HourHandModelPort) {
        this.finca_HourHandModelPort = finca_HourHandModelPort;
    }

    @Override
    public Boolean delete(Long id) {
        return finca_HourHandModelPort.delete(id);
    }
    @Override
    public Finca_HourHand logicalDeletion(Finca_HourHand delete) {
        return finca_HourHandModelPort.logicalDeletion(delete);
    }
}
