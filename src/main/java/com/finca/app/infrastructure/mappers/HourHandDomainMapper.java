package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.HourHand;

import com.finca.app.infrastructure.entities.HourHandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HourHandDomainMapper {

    @Mapping(source = "id", target = "hourHandID")
    HourHand toDomainModel(HourHandEntity entity);

    @Mapping(source = "hourHandID", target = "id")
    HourHandEntity fromDomainModel(HourHand model);
}
