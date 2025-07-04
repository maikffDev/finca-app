package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FincaHourHandDomainMapper {

    @Autowired
    FincaDomainMapper fincaDomainMapper;

    @Autowired
    HourHandDomainMapper hourHandDomainMapper;

    public  Finca_HourHand fromEntityToModel (FincaHourHandEntity fincaHourHandEntity) {
        return Finca_HourHand.builder()
                .finca(fincaDomainMapper.toDomainModel(fincaHourHandEntity.getFinca()))
                .hourHand(hourHandDomainMapper.toDomainModel(fincaHourHandEntity.getHourHandEntity()))
                .reserved(fincaHourHandEntity.isReserved())
                .pricePerHour(fincaHourHandEntity.getPricePerHour())
                .build();
    }

}
