package com.finca.app.application.mappers;

import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTORequest;
import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTOResponse;
import com.finca.app.application.services.finca.impl.FincaModelService;
import com.finca.app.application.services.schedule.impl.ScheduleModelService;
import com.finca.app.application.services.util.GenericErrorException;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaScheduleDTOMapper {

    @Autowired
    FincaModelService fincaModelService;
    @Autowired
    ScheduleModelService scheduleModelService;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaIdToFinca")
    @Mapping(source = "scheduleId", target = "schedule", qualifiedByName = "mapScheduleIdToSchedule")
    public abstract FincaSchedule toModel(FincaScheduleDTORequest fincaScheduleDTORequest);

    @Mapping(source = "finca.id", target = "fincaId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    public abstract FincaScheduleDTOResponse toDto(FincaSchedule fincaSchedule);

    public abstract List<FincaScheduleDTOResponse> toDtoList(List<FincaSchedule> fincaSchedules);

    @Named("mapFincaIdToFinca")
    protected Finca mapFincaIdToFinca(Long fincaId){
        return fincaModelService.getById(fincaId).orElseThrow(() -> new GenericErrorException("Can't create or update FincaSchedule relation. Finca '" + fincaId + "' not found."));
    }

    @Named("mapScheduleIdToSchedule")
    protected Schedule mapScheduleIdToSchedule(Long scheduleId){
        return scheduleModelService.getById(scheduleId).orElseThrow(() -> new GenericErrorException("Can't create or update FincaSchedule relation. Schedule '" + scheduleId + "' not found."));
    }
}
