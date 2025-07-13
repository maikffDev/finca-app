package com.finca.app.domain.ports.in.finca;

import com.finca.app.domain.models.Finca;

public interface DeleteFincaUseCase {
    Boolean delete(Long id);

    Finca logicalDeletion(Finca finca);
}
