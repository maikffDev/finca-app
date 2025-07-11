package com.finca.app.application.usecases.amenitie;

import com.finca.app.domain.models.Amenitie;
import com.finca.app.domain.ports.in.amenitie.CreateAmenitieUseCase;
import com.finca.app.domain.ports.out.AmenitieModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateAmenitieUseCaseImpl implements CreateAmenitieUseCase {

    private final AmenitieModelPort amenitieModelPort;

    public CreateAmenitieUseCaseImpl(AmenitieModelPort amenitieModelPort) {
        this.amenitieModelPort = amenitieModelPort;
    }

    @Override
    public Amenitie createAmenitie(Amenitie amenitie) {
        return amenitieModelPort.save(amenitie);
    }
}