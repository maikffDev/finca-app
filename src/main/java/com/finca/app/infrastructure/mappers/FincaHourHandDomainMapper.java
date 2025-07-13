package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class FincaHourHandDomainMapper {

    @Autowired
    @Lazy
    FincaDomainMapper fincaDomainMapper;

    @Autowired
    HourHandDomainMapper hourHandDomainMapper;

    public  Finca_HourHand fromEntityToModel (FincaHourHandEntity fincaHourHandEntity) {
        return Finca_HourHand.builder()
                .id(fincaHourHandEntity.getId())
                .finca(fincaDomainMapper.toDomainModel(fincaHourHandEntity.getFinca()))
                .hourHand(hourHandDomainMapper.toDomainModel(fincaHourHandEntity.getHourHandEntity()))
                .reserved(fincaHourHandEntity.isReserved())
                .pricePerHour(fincaHourHandEntity.getPricePerHour())
                .build();
    }

    public List<Finca_HourHand> fromEntitiesToModels(List<FincaHourHandEntity> entities) {
        return entities.stream()
                .map(this::fromEntityToModel)
                .collect(Collectors.toList());
    }

    public Finca_HourHand toDomainWithoutFinca(FincaHourHandEntity e) {
        return Finca_HourHand.builder()
                .id(e.getId())
                // solo datos propios
                .hourHand(hourHandDomainMapper.toDomainModel(e.getHourHandEntity()))
                .reserved(e.isReserved())
                .pricePerHour(e.getPricePerHour())
                .build();
    }

    /** Lista usando el mapeo ligero */
    public List<Finca_HourHand> toDomainListWithoutFinca(List<FincaHourHandEntity> list) {
        if (list == null || list.isEmpty()) return List.of();
        return list.stream()
                .map(this::toDomainWithoutFinca)
                .toList();
    }

}
