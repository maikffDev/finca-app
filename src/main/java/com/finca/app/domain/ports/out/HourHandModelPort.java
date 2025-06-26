package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.HourHand;

import java.util.List;
import java.util.Optional;

public interface HourHandModelPort {
    HourHand save(HourHand hourHand);
    List<HourHand> findAll();
    Optional<HourHand> findById(Long id);
    HourHand update(HourHand hourHand);
    boolean deleteById(Long id);
}
