package com.finca.app.application.usecases.commentary;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.ports.in.commentary.UpdateCommentaryUseCase;
import com.finca.app.domain.ports.out.CommentaryModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Primary
@Service
public class UpdateCommentaryUseCaseImpl implements UpdateCommentaryUseCase {

    private CommentaryModelPort commentaryModelPort;

    public UpdateCommentaryUseCaseImpl(CommentaryModelPort commentaryModelPort){
        this.commentaryModelPort = commentaryModelPort;
    }

    @Override
    public Commentary update(Commentary commentary) {
        return commentaryModelPort.update(commentary);
    }
}
