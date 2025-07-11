package com.finca.app.application.usecases.amenitie;

import com.finca.app.domain.ports.in.amenitie.DeleteAmenitieUseCase;
import com.finca.app.domain.ports.out.AmenitieModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteAmenitieUseCaseImpl implements DeleteAmenitieUseCase {
    private final AmenitieModelPort amenitieModelPort;

    public DeleteAmenitieUseCaseImpl(AmenitieModelPort amenitieModelPort) {
        this.amenitieModelPort = amenitieModelPort;
    }

    @Override
    public boolean deleteAmenitieById(Long id) {
        return amenitieModelPort.deleteById(id);
    }
}