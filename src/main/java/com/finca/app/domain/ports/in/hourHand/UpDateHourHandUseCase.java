package com.finca.app.domain.ports.in.hourHand;

import com.finca.app.domain.models.HourHand;

public interface UpDateHourHandUseCase {
    HourHand update(HourHand hourHand);
}
