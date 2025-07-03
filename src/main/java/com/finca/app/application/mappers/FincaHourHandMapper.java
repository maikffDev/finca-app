package com.finca.app.application.mappers;

import com.finca.app.application.dto.FincaHourHnad.FincaHourHandDTORequest;
import com.finca.app.application.service.finca.FincaService;
import com.finca.app.application.service.finca.impl.FincaModelService;
import com.finca.app.application.service.hourhand.impl.HourHandModelService;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.models.HourHand;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class FincaHourHandMapper {

    @Autowired
    FincaModelService fincaModelService;

    @Autowired
    HourHandModelService hourHandModelService;

    @Mapping(source = "hourHandId", target = "hourHand", qualifiedByName = "mapHourHandIdToHourHand")
    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaIdToFinca")
    public abstract Finca_HourHand fromDTOToModel(FincaHourHandDTORequest dto);

    public List<Finca_HourHand> fromDTOsToModels(List<FincaHourHandDTORequest> dtoList) {
        return dtoList.stream()
                .map(this::fromDTOToModel)
                .collect(Collectors.toList());
    }

    @Named("mapFincaIdToFinca")
    protected Finca mapFincaIdToFinca(Long fincaId) {
        return fincaModelService.getById(fincaId)
                .orElseThrow(() -> new GenericErrorException("No se pudo encontrar la finca con ID '" + fincaId + "'."));
    }

    @Named("mapHourHandIdToHourHand")
    protected HourHand mapHourHandIdToHourHand(Long hourHandId) {
        return hourHandModelService.findById(hourHandId)
                .orElseThrow(() -> new GenericErrorException("No se pudo encontrar el HourHand con ID '" + hourHandId + "'."));
    }
}
