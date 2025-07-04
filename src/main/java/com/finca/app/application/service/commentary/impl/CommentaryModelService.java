package com.finca.app.application.service.commentary.impl;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.ports.in.commentary.CreateCommentaryUseCase;
import com.finca.app.domain.ports.in.commentary.DeleteCommentaryUseCase;
import com.finca.app.domain.ports.in.commentary.FindCommentaryUseCase;
import com.finca.app.domain.ports.in.commentary.UpdateCommentaryUseCase;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class CommentaryModelService implements CreateCommentaryUseCase, DeleteCommentaryUseCase, FindCommentaryUseCase, UpdateCommentaryUseCase {

    private final CreateCommentaryUseCase createCommentaryUseCase;
    private final DeleteCommentaryUseCase deleteCommentaryUseCase;
    private final FindCommentaryUseCase findCommentaryUseCase;
    private final UpdateCommentaryUseCase updateCommentaryUseCase;

    public CommentaryModelService(CreateCommentaryUseCase createCommentaryUseCase, DeleteCommentaryUseCase deleteCommentaryUseCase, FindCommentaryUseCase findCommentaryUseCase, UpdateCommentaryUseCase updateCommentaryUseCase) {
        this.createCommentaryUseCase = createCommentaryUseCase;
        this.deleteCommentaryUseCase = deleteCommentaryUseCase;
        this.findCommentaryUseCase = findCommentaryUseCase;
        this.updateCommentaryUseCase = updateCommentaryUseCase;
    }

    @Override
    @Transactional
    public Commentary create(Commentary commentary) {
        return createCommentaryUseCase.create(commentary);
    }

    @Override
    public Boolean delete(Long id) {
        return deleteCommentaryUseCase.delete(id);
    }

    @Override
    public Commentary logicalDeletion(Commentary commentary) {
        return deleteCommentaryUseCase.logicalDeletion(commentary);
    }

    @Override
    public List<Commentary> getAll() {
        return findCommentaryUseCase.getAll();
    }

    @Override
    public Optional<Commentary> getById(Long id) {
        return findCommentaryUseCase.getById(id);
    }

    @Override
    public List<Commentary> getByUserId(Long userId) {
        return findCommentaryUseCase.getByUserId(userId);
    }

    @Override
    public List<Commentary> getByFincaId(Long fincaId) {
        return findCommentaryUseCase.getByFincaId(fincaId);
    }


    @Override
    public Commentary update(Commentary commentary) {
        return updateCommentaryUseCase.update(commentary);
    }
}
