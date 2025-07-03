package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Finca_HourHand;

import java.util.List;
import java.util.Optional;

public interface Finca_HourHandModelPort {
    Finca_HourHand save(Finca_HourHand fincaHourHand);

    Finca_HourHand update(Finca_HourHand fincaHourHand);
    List<Finca_HourHand> getById(Long finca_HourHandId);
    List<Finca_HourHand> findAll();
    List<Finca_HourHand> getByFincaId(Long fincaId);
    List<Finca_HourHand> getByHourHandId(Long hourHandId);
    Boolean delete(Long FincaHourHandid);
    Finca_HourHand logicalDeletion(Finca_HourHand finca_hourHand);
}
