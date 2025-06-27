package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Finca;
import com.finca.app.infrastructure.entities.FincaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDomainMapper {

    public abstract FincaEntity fromDomainModel(Finca finca);

    public abstract Finca toDomainModel(FincaEntity fincaEntity);

    public abstract List<FincaEntity> fromDomainModelList(List<Finca> fincas);
}
