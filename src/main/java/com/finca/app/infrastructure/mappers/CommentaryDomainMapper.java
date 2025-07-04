package com.finca.app.infrastructure.mappers;


import com.finca.app.domain.models.Commentary;
import com.finca.app.infrastructure.entities.CommentaryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentaryDomainMapper {

    public abstract CommentaryEntity fromDomainModel(Commentary commentary);

    public abstract Commentary toDomainModel(CommentaryEntity commentaryEntity);

    public abstract List<CommentaryEntity> fromDomainModelList(List<Commentary> commentary);
}
