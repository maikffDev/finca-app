package com.finca.app.insfraestructure.mappers;

import com.finca.app.domain.models.HourHand;
import com.finca.app.insfraestructure.entities.HourHandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HourHandDomainMapper {

    HourHand toDomainModel(HourHandEntity entity);

    HourHandEntity fromDomainModel(HourHand model);
}
