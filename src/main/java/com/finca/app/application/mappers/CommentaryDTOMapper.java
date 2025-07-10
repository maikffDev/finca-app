package com.finca.app.application.mappers;

import com.finca.app.application.dto.commentary.ComentaryDtoRequest;
import com.finca.app.application.dto.commentary.CommentaryDtoResponse;
import com.finca.app.domain.models.Commentary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentaryDTOMapper {

    @Mappings({
            @Mapping(target = "commentaryId", ignore = true), // No se envía desde el DTORequest
            @Mapping(source = "description", target = "description"),
            @Mapping(target = "user", ignore = true),          // Se inyecta en el service usando userId
            @Mapping(target = "finca", ignore = true),         // Se inyecta en el service usando fincaId
            @Mapping(target = "reservation", ignore = true)    // Si aplica luego
    })
    public abstract Commentary toModel(ComentaryDtoRequest commentaryDto);

    public abstract List<CommentaryDtoResponse> toDtoList(List<Commentary> commentaryList);

    public CommentaryDtoResponse toDto(Commentary commentary) {
        return CommentaryDtoResponse.builder()
                .commentaryId(commentary.getCommentaryId())
                .description(commentary.getDescription())
                .userId(commentary.getUser() != null ? commentary.getUser().getUserId() : null)
                .fincaId(commentary.getFinca() != null ? commentary.getFinca().getId() : null)
                .build();
    }
}