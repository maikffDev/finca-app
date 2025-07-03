package com.finca.app.domain.ports.in.finca_HourHand;

import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.models.HourHand;

public interface DeleteFinca_HourHandUseCase {
    Boolean delete(Long finca_HourHandId);
    Finca_HourHand logicalDeletion(Finca_HourHand finca_HourHand);
}
