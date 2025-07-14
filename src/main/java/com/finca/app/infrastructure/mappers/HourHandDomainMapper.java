package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.HourHand;

import com.finca.app.infrastructure.entities.HourHandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class HourHandDomainMapper {

    @Mapping(source = "id", target = "hourHandID")
    public abstract HourHand toDomainModel(HourHandEntity entity);

    @Mapping(source = "hourHandID", target = "id")
    public abstract HourHandEntity fromDomainModel(HourHand model);
}
