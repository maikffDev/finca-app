package com.finca.app.application.service.hourhand.impl;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.ports.in.hourHand.CreateHourHandUseCase;
import com.finca.app.domain.ports.in.hourHand.DeleteHouraHandUseCase;
import com.finca.app.domain.ports.out.HourHandModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourHandModelService {

    private final HourHandModelPort repository;

    public HourHandModelService(HourHandModelPort repository) {
        this.repository = repository;
    }

    public HourHand create(HourHand hourHand) {

        return repository.save(hourHand);
    }

    public List<HourHand> findAll() {
        return repository.findAll();
    }

    public Optional<HourHand> findById(Long id) {
        return repository.findById(id);
    }


    public HourHand update(HourHand hourHand) {
        return repository.update(hourHand);
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    public HourHand logicalDeletion(HourHand hourHand) {
        return repository.update(hourHand); // lógica definida por vos
    }
}