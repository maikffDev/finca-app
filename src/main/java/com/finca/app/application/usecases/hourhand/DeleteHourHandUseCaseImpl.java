package com.finca.app.application.usecases.hourhand;

import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.ports.in.hourHand.DeleteHouraHandUseCase;
import com.finca.app.domain.ports.out.HourHandModelPort;

public class DeleteHourHandUseCaseImpl implements DeleteHouraHandUseCase {
    private HourHandModelPort hourHandModelPort;

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public HourHand logicalDeletion(HourHand hourHand) {
        return null;
    }
}
