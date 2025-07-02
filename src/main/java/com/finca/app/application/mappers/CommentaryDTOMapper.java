package com.finca.app.application.mappers;

import com.finca.app.application.dto.commentary.ComentaryDtoRequest;
import com.finca.app.application.dto.commentary.CommentaryDtoResponse;
import com.finca.app.domain.models.Commentary;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentaryDTOMapper {

    public abstract Commentary toModel(ComentaryDtoRequest commentaryDto);
    public abstract CommentaryDtoResponse toDto(Commentary commentary);
    public abstract List<CommentaryDtoResponse> toDtoList(List<Commentary> commentary);

}
