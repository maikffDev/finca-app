package com.finca.app.application.usecases.commentary;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.ports.in.commentary.FindCommentaryUseCase;
import com.finca.app.domain.ports.out.CommentaryModelPort;

import java.util.List;
import java.util.Optional;

public class FindCommentaryUseCaseImpl implements FindCommentaryUseCase {


    private CommentaryModelPort commentaryModelPort;

   public FindCommentaryUseCaseImpl(CommentaryModelPort commentaryModelPort){
       this.commentaryModelPort = commentaryModelPort;
   }

    @Override
    public List<Commentary> getAll() {
        return commentaryModelPort.getAll();
    }

    @Override
    public Optional<Commentary> getById(Long id) {
        return commentaryModelPort.getById(id);
    }

    @Override
    public List<Commentary> getByUserId(Long userId) {
        return commentaryModelPort.getByUserId(userId);
    }

    @Override
    public List<Commentary> getByFincaId(Long fincaId) {
        return commentaryModelPort.getByFincaId(fincaId);
    }
}
