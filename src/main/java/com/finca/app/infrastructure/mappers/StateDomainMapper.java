package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.State;
import com.finca.app.infrastructure.entities.StateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StateDomainMapper {

   public abstract State toModel(StateEntity entity);

   public abstract StateEntity toEntity(State state);
}
