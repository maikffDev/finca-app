package com.finca.app.application.usecases.hourhand;

import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.ports.in.hourHand.CreateHourHandUseCase;
import com.finca.app.domain.ports.out.HourHandModelPort;
import jakarta.transaction.Transactional;

public class CreateHurHandUseCaseImpl implements CreateHourHandUseCase {
    private final HourHandModelPort hourHandModelPort;

    public CreateHurHandUseCaseImpl(HourHandModelPort hourHandPort){this.hourHandModelPort = hourHandPort;}

    @Override
    @Transactional
    public HourHand create(HourHand hourHand) { return hourHandModelPort.save(hourHand);}
}
