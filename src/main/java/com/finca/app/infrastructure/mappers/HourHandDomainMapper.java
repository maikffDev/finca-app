package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.HourHand;

import com.finca.app.infrastructure.entities.HourHandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class HourHandDomainMapper {

    @Mapping(source = "id", target = "hourHandID")
    public abstract HourHand toDomainModel(HourHandEntity entity);

    @Mapping(source = "hourHandID", target = "id")
    public abstract HourHandEntity fromDomainModel(HourHand model);

    public List<HourHand> fromEntitiesToDomains(List<HourHandEntity> entities) {
        if (entities == null || entities.isEmpty()) return Collections.emptyList();
        return entities.stream()
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }
}
