package com.finca.app.domain.ports.in.commentary;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.models.Finca;
import org.yaml.snakeyaml.tokens.CommentToken;

public interface DeleteCommentaryUseCase {

    Boolean delete(Long id);

    Commentary logicalDeletion(Commentary commentary);
}
