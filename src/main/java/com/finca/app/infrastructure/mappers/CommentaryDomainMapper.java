package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Commentary;
import com.finca.app.infrastructure.entities.CommentaryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentaryDomainMapper {

    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "finca", target = "finca"),
            @Mapping(source = "description", target = "description")
            // Otros campos se ignoran automáticamente
    })
    public abstract CommentaryEntity fromDomainModel(Commentary commentary);

    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "finca", target = "finca"),
            @Mapping(source = "description", target = "description")
    })
    public abstract Commentary toDomainModel(CommentaryEntity commentaryEntity);

    public abstract List<CommentaryEntity> fromDomainModelList(List<Commentary> commentary);

    public abstract List<Commentary> toDomainModelList(List<CommentaryEntity> commentaryEntities);
}