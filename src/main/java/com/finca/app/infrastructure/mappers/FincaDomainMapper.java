package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Finca;
import com.finca.app.infrastructure.entities.FincaEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDomainMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "ubication", target = "ubication"),
            @Mapping(source = "pricePerHour", target = "pricePerHour"),
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "availableSchedules", target = "availableSchedules")
            // amenities e images se ignoran en este mapeo
    })
    public abstract FincaEntity fromDomainModel(Finca finca);

    @InheritInverseConfiguration
    public abstract Finca toDomainModel(FincaEntity fincaEntity);

    public abstract List<FincaEntity> fromDomainModelList(List<Finca> fincas);

    public abstract List<Finca> toDomainModelList(List<FincaEntity> fincaEntities);
}