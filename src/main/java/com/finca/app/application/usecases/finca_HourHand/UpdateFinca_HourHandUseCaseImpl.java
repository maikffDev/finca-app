package com.finca.app.application.usecases.finca_HourHand;


import com.finca.app.domain.models.Finca_HourHand;

import com.finca.app.domain.ports.in.finca_HourHand.UpdateFinca_HourHandUseCase;
import com.finca.app.domain.ports.out.Finca_HourHandModelPort;

public class UpdateFinca_HourHandUseCaseImpl implements UpdateFinca_HourHandUseCase {

    private final Finca_HourHandModelPort finca_HourHandModelPort;

    public UpdateFinca_HourHandUseCaseImpl(Finca_HourHandModelPort finca_HourHandModelPort){ this.finca_HourHandModelPort = finca_HourHandModelPort;}

    @Override
    public Finca_HourHand update(Finca_HourHand finca_HourHand){ return finca_HourHandModelPort.update(finca_HourHand);}
}
