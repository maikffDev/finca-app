package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Commentary;

import java.util.List;
import java.util.Optional;

public interface CommentaryModelPort {

    Commentary save(Commentary commentary);


    Boolean delete(Long id);

    Commentary logicalDeletion(Commentary commentary);

    List<Commentary> getAll();

    Optional<Commentary> getById(Long id);

    List<Commentary> getByUserId(Long userId);

    List<Commentary> getByFincaId(Long fincaId);

    Commentary update(Commentary commentary);

}
