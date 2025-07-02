package com.finca.app.application.usecases.commentary;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.ports.in.commentary.CreateCommentaryUseCase;
import com.finca.app.domain.ports.out.CommentaryModelPort;

public class CreateCommentaryUseCaseImpl implements CreateCommentaryUseCase {

    private CommentaryModelPort commentaryModelPort;

    public CreateCommentaryUseCaseImpl(CommentaryModelPort commentaryModelPort){
        this.commentaryModelPort = commentaryModelPort;
    }

    @Override
    public Commentary create(Commentary commentary) {
        return commentaryModelPort.save(commentary);
    }
}
