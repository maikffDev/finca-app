package com.finca.app.domain.ports.in.commentary;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.models.Finca;

import java.util.List;
import java.util.Optional;

public interface FindCommentaryUseCase {

    List<Commentary> getAll();

    Optional<Commentary> getById(Long id);

    List<Commentary> getByUserId(Long userId);
    List<Commentary> getByFincaId(Long fincaId);
}
