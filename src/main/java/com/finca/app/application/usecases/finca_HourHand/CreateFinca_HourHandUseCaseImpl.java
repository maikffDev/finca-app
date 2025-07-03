package com.finca.app.application.usecases.finca_HourHand;


import com.finca.app.domain.models.Finca_HourHand;

import com.finca.app.domain.ports.in.finca_HourHand.CreateFinca_HourHandUseCase;
import com.finca.app.domain.ports.out.Finca_HourHandModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateFinca_HourHandUseCaseImpl implements CreateFinca_HourHandUseCase {
    private final Finca_HourHandModelPort fincaHourHandModelPort;

    public CreateFinca_HourHandUseCaseImpl(Finca_HourHandModelPort finca_hourHand){this.fincaHourHandModelPort = finca_hourHand;}

    @Override
    public Finca_HourHand create(Finca_HourHand finca_hourHand){return fincaHourHandModelPort.save(finca_hourHand);}
}
