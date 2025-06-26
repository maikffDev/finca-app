package com.finca.app.domain.ports.in.hourHand;

import com.finca.app.domain.models.HourHand;

public interface CreateHourHandUseCase {
    HourHand create(HourHand hourHand);
}
