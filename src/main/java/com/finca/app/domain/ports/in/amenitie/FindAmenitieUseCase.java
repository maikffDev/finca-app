package com.finca.app.domain.ports.in.amenitie;

import com.finca.app.domain.models.Amenitie;

import java.util.List;
import java.util.Optional;

public interface FindAmenitieUseCase {
    Optional<Amenitie> getAmenitieById(Long id);
    List<Amenitie> getAllAmenities();
}