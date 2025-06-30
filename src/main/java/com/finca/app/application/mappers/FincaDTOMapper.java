package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.domain.models.Finca;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDTOMapper {
    public abstract Finca toModel(FincaDTORequest fincaDto);

    public abstract FincaDTOResponse toDto(Finca finca);

    public abstract List<FincaDTOResponse> toDtoList(List<Finca> finca);
}
