package com.finca.app.domain.ports.in;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Finca_HourHand;

public interface UpdateFincaUseCase {
    Finca update(Finca finca);

    Finca_HourHand update(Finca_HourHand finca_HourHand);
}
