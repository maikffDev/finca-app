package com.finca.app.domain.ports.in.finca;

import com.finca.app.domain.models.Finca;

public interface CreateFincaUseCase {
    Finca create(Finca finca);
}
