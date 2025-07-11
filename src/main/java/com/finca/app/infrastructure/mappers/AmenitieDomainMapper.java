package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Amenitie;
import com.finca.app.infrastructure.entities.AmenitieEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AmenitieDomainMapper {
    Amenitie toDomainModel(AmenitieEntity entity);
    AmenitieEntity fromDomainModel(Amenitie domainModel);
}