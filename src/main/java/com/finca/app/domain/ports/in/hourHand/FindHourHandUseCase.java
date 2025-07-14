package com.finca.app.domain.ports.in.hourHand;

import com.finca.app.domain.models.HourHand;

import java.util.List;

public interface FindHourHandUseCase {
    List<HourHand> findAll();
}
