package com.finca.app.application.service.commentary;

import com.finca.app.application.dto.commentary.ComentaryDtoRequest;
import com.finca.app.application.dto.commentary.CommentaryDtoResponse;

import java.util.List;

public interface CommentaryService {

    CommentaryDtoResponse create(ComentaryDtoRequest commentaryDto);
    CommentaryDtoResponse getById(Long id);
    List<CommentaryDtoResponse> getByUserId(Long userId);
    CommentaryDtoResponse update(Long commentaryId, ComentaryDtoRequest commentaryDtoToUpdate);
    CommentaryDtoResponse delete(Long commentaryId);
    List<CommentaryDtoResponse> getByFincaId(Long fincaId);
}

