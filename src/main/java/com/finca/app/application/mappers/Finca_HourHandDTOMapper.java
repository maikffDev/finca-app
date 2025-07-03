package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTORequest;
import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTOResponse;
import com.finca.app.domain.models.Finca_HourHand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class Finca_HourHandDTOMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "finca", expression = "java(new Finca(request.getFincaId(), null))")
    @Mapping(target = "hourHand", expression = "java(new HourHand(request.getHourHandId(), null, null))")
    public abstract Finca_HourHand toModel(Finca_HourHandDTORequest dto);


    @Mapping(source = "finca.id", target = "fincaId")
    @Mapping(source = "finca.name", target = "fincaName")
    @Mapping(source = "hourHand.id", target = "hourHandId")
    @Mapping(source = "hourHand.startTime", target = "hourHandStartTime")
    @Mapping(source = "hourHand.endTime", target = "hourHandEndTime")
    public abstract Finca_HourHandDTOResponse toDto(Finca_HourHand finca_hourHand);
    public abstract List<Finca_HourHandDTOResponse> toDtoList(List<Finca_HourHand> domains);
}
