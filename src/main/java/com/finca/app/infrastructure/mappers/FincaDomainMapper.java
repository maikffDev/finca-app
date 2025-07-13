package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.*;
import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class FincaDomainMapper {

    @Autowired
    UserDomainMapper userDomainMapper;

    @Autowired
    @Lazy
    ImageDomainMapper imageDomainMapper;

    @Autowired
    HourHandDomainMapper hourHandDomainMapper;

    @Autowired
    @Lazy
    FincaHourHandDomainMapper fincaHourHandDomainMapper;

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

    @Named("manualFincaMapping")
    public Finca fromEntityToDomainManual( FincaEntity fincaEntity){
        User userModel = userDomainMapper.toDomainModel(fincaEntity.getUser());
        List<Image> imageModelList = imageDomainMapper.fromEntitiesToDomains(fincaEntity.getImages());
        List<Finca_HourHand> fincaHourHandList = fincaHourHandDomainMapper.toDomainListWithoutFinca(fincaEntity.getAvailableSchedules());

        List<HourHand> hourHandModelList = fincaHourHandList.stream()
                .map(Finca_HourHand::getHourHand)
                .collect(Collectors.toList());


           return Finca.builder()
                   .id(fincaEntity.getId())
                   .name(fincaEntity.getName())
                   .ubication(fincaEntity.getUbication())
                   .pricePerHour(fincaEntity.getPricePerHour())
                   .availableSchedules(hourHandModelList) //mapear c
                   .description(fincaEntity.getDescription())
                   .active(fincaEntity.isActive())
                   .user(userModel) //MAPEAR con user mapper
                   .images(imageModelList) //Mapear con Image mapper
                   .build();
    }
}