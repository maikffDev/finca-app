package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Finca;
import com.finca.app.infrastructure.entities.FincaEntity;

import java.util.List;
import java.util.Optional;

public interface FincaModelPort {
    Finca save(Finca finca);

    List<Finca> findAll();

    Optional<Finca> findById(Long id);

    Optional<Finca> findByUsername(String username);

    Finca update(Finca finca);

    Boolean delete(Long id);

    Finca logicalDeletion(Finca finca);

    List<FincaEntity> getAllAvailableFincas();
}
