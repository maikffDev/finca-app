package com.finca.app.domain.ports.in.amenitie;

import com.finca.app.domain.models.Amenitie;

public interface CreateAmenitieUseCase {
    Amenitie createAmenitie(Amenitie amenitie);
}