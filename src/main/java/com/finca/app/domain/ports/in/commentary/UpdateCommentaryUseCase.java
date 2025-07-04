package com.finca.app.domain.ports.in.commentary;

import com.finca.app.domain.models.Commentary;

public interface UpdateCommentaryUseCase {

    Commentary update(Commentary commentary);
}
