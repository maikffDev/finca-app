package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.HourHand;

import com.finca.app.infrastructure.entities.HourHandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HourHandDomainMapper {

    HourHand toDomainModel(HourHandEntity entity);

    HourHandEntity fromDomainModel(HourHand model);
}
