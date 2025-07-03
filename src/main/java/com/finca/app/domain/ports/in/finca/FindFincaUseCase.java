package com.finca.app.domain.ports.in.finca;

import com.finca.app.domain.models.Finca;

import java.util.List;
import java.util.Optional;

public interface FindFincaUseCase {
    List<Finca> getAll();

    Optional<Finca> getById(Long id);

    Optional<Finca> getByName(String name);
}
