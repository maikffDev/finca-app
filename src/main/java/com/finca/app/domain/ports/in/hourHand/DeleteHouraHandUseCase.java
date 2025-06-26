package com.finca.app.domain.ports.in.hourHand;

import com.finca.app.domain.models.HourHand;

public interface DeleteHouraHandUseCase {
    Boolean delete(Long id);

    HourHand logicalDeletion(HourHand hourHand);
}
