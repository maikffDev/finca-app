package com.finca.app.application.usecases.amenitie;

import com.finca.app.domain.models.Amenitie;
import com.finca.app.domain.ports.in.amenitie.FindAmenitieUseCase;
import com.finca.app.domain.ports.out.AmenitieModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindAmenitieUseCaseImpl implements FindAmenitieUseCase {

    private final AmenitieModelPort amenitieModelPort;

    public FindAmenitieUseCaseImpl(AmenitieModelPort amenitieModelPort) {
        this.amenitieModelPort = amenitieModelPort;
    }

    @Override
    public Optional<Amenitie> getAmenitieById(Long id) {
        return amenitieModelPort.findById(id);
    }

    @Override
    public List<Amenitie> getAllAmenities() {
        return amenitieModelPort.findAll();
    }
}