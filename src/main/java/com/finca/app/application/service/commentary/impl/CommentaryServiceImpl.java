package com.finca.app.application.service.commentary.impl;

import com.finca.app.application.dto.commentary.ComentaryDtoRequest;
import com.finca.app.application.dto.commentary.CommentaryDtoResponse;
import com.finca.app.application.mappers.CommentaryDTOMapper;
import com.finca.app.application.service.commentary.CommentaryService;
import com.finca.app.domain.models.Commentary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaryServiceImpl implements CommentaryService {

    private final CommentaryModelService commentaryModelService;
    private final CommentaryDTOMapper commentaryDTOMapper;

    public CommentaryServiceImpl(CommentaryModelService commentaryModelService, CommentaryDTOMapper commentaryDTOMapper) {
        this.commentaryModelService = commentaryModelService;
        this.commentaryDTOMapper = commentaryDTOMapper;
    }

    @Override
    @Transactional
    public CommentaryDtoResponse create(ComentaryDtoRequest commentaryDtoRequest) {
        Commentary commentary = commentaryDTOMapper.toModel(commentaryDtoRequest);
        Commentary newCommentary = commentaryModelService.create(commentary);
        return commentaryDTOMapper.toDto(newCommentary);
    }

    @Override
    public CommentaryDtoResponse getById(Long commentaryId) {
        Commentary commentary = commentaryModelService.getById(commentaryId)
                .orElseThrow(() -> new RuntimeException("Commentary with id '" + commentaryId + "' not found."));
        return commentaryDTOMapper.toDto(commentary);
    }

    @Override
    public List<CommentaryDtoResponse> getByUserId(Long userId) {
        List<Commentary> commentaries = commentaryModelService.getByUserId(userId);
        if (commentaries.isEmpty()) {
            throw new RuntimeException("No commentaries found for user id '" + userId + "'.");
        }
        return commentaryDTOMapper.toDtoList(commentaries);
    }

    @Override
    public CommentaryDtoResponse update(Long commentaryId, ComentaryDtoRequest commentaryDtoToUpdate) {
        Commentary commentary = commentaryModelService.getById(commentaryId)
                .orElseThrow(() -> new RuntimeException("Commentary with id '" + commentaryId + "' not found."));
        Commentary toUpdate = commentaryDTOMapper.toModel(commentaryDtoToUpdate);

        commentary.setDescription(toUpdate.getDescription());
        Commentary updated = commentaryModelService.update(commentary);
        return commentaryDTOMapper.toDto(updated);
    }

    @Override
    public CommentaryDtoResponse delete(Long commentaryId) {
        Commentary commentary = commentaryModelService.getById(commentaryId)
                .orElseThrow(() -> new RuntimeException("Commentary with id '" + commentaryId + "' not found."));
        boolean deleted = commentaryModelService.delete(commentaryId);
        if (deleted) {
            return commentaryDTOMapper.toDto(commentary);
        }
        throw new RuntimeException("Could not delete commentary with id '" + commentaryId + "'. Try again.");
    }

    @Override
    public List<CommentaryDtoResponse> getByFincaId(Long fincaId) {
        List<Commentary> commentaries = commentaryModelService.getByFincaId(fincaId);
        if (commentaries.isEmpty()) {
            throw new RuntimeException("No commentaries found for finca id '" + fincaId + "'.");
        }
        return commentaryDTOMapper.toDtoList(commentaries);
    }
}