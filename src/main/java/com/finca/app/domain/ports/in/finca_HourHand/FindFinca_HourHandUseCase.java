package com.finca.app.domain.ports.in.finca_HourHand;

import com.finca.app.domain.models.Finca_HourHand;

import java.util.List;

public interface FindFinca_HourHandUseCase {

    List<Finca_HourHand> getAll();
    List<Finca_HourHand> getById(Long id);
    List<Finca_HourHand> getByFincaId(Long fincaId);
    List<Finca_HourHand> getByHourHandId(Long hourHandId);
}
