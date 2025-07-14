package com.finca.app.application.mappers;

import com.finca.app.application.dto.state.StateDTORequest;
import com.finca.app.application.dto.state.StateDTOResponse;
import com.finca.app.domain.models.State;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StateDTOMapper {

    public abstract State toModel(StateDTORequest stateDto);

    public abstract StateDTOResponse toDto(State state);

    public abstract List<StateDTOResponse> toDtoList(List<State> states);
}
