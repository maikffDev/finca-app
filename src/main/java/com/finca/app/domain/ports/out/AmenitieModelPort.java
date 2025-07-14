package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Amenitie;

import java.util.List;
import java.util.Optional;

public interface AmenitieModelPort {
    Amenitie save(Amenitie amenitie);
    Optional<Amenitie> findById(Long id);
    List<Amenitie> findAll();
    boolean deleteById(Long id);
    boolean existsById(Long id);
}