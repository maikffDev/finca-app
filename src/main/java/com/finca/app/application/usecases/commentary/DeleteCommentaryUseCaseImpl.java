package com.finca.app.application.usecases.commentary;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.ports.in.commentary.DeleteCommentaryUseCase;
import com.finca.app.domain.ports.out.CommentaryModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;

@Primary
@Service
public class DeleteCommentaryUseCaseImpl implements DeleteCommentaryUseCase {

    private CommentaryModelPort commentaryModelPort;

    public DeleteCommentaryUseCaseImpl(CommentaryModelPort commentaryModelPort){
        this.commentaryModelPort = commentaryModelPort;
    }


    @Override
    public Boolean delete(Long id) {
        return commentaryModelPort.delete(id);
    }

    @Override
    public Commentary logicalDeletion(Commentary commentary) {
        return commentaryModelPort.logicalDeletion(commentary);
    }
}
