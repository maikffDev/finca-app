package com.finca.app.domain.ports.in.finca_HourHand;

import com.finca.app.domain.models.Finca_HourHand;

public interface UpdateFinca_HourHandUseCase {
    Finca_HourHand update(Finca_HourHand finca_HourHandUpdates);

}
