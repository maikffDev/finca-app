package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.infrastructure.entities.Finca_HourHandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Finca_HourHandDomainMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fincaId", target = "fincaId")
    @Mapping(source = "hourHandId", target = "hourHandId")
    @Mapping(source = "hourHandStartTime", target = "hourHandStartTime")
    @Mapping(source = "hourHandEndTime", target = "hourHandEndTime")
    Finca_HourHand toDomainModel(Finca_HourHandEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fincaId", target = "fincaId")
    @Mapping(source = "hourHandId", target = "hourHandId")
    @Mapping(source = "hourHandStartTime", target = "hourHandStartTime")
    @Mapping(source = "hourHandEndTime", target = "hourHandEndTime")
    Finca_HourHandEntity fromDomainModel(Finca_HourHand domain);
}
