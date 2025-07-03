package com.finca.app.infrastructure.mappers;

import com.finca.app.application.util.GenericErrorException;
import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.entities.FincaScheduleEntity;
import com.finca.app.infrastructure.entities.ScheduleEntity;
import com.finca.app.infrastructure.repositories.JpaFincaRepository;
import com.finca.app.infrastructure.repositories.JpaScheduleRepository;
import com.finca.app.infrastructure.repositories.JpaUserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class FincaScheduleDomainMapper {

    @Autowired
    JpaFincaRepository jpaFincaRepository;
    @Autowired
    JpaScheduleRepository jpaScheduleRepository;

    @Mapping(source = "finca.id", target = "finca", qualifiedByName = "mapFincaIdToFinca")
    @Mapping(source = "schedule.id", target = "schedule", qualifiedByName = "mapScheduleIdToSchedule")
    public abstract FincaScheduleEntity fromDomainModel(FincaSchedule fincaSchedule);

    @Mapping(source = "finca", target = "finca")
    @Mapping(source = "schedule", target = "schedule")
    public abstract FincaSchedule toDomainModel(FincaScheduleEntity fincaScheduleEntity);

    public abstract List<FincaScheduleEntity> fromDomainModelList(List<FincaSchedule> fincaSchedules);

    @Named("mapFincaIdToFinca")
    protected FincaEntity mapFincaIdToFinca(Long fincaId){
        return jpaFincaRepository.findById(fincaId).orElseThrow(() -> new GenericErrorException("Can't create or update Finca-Schedule relation. Finca '" + fincaId + "' not found."));
    }

    @Named("mapScheduleIdToSchedule")
    protected ScheduleEntity mapScheduleIdToSchedule(Long scheduleId){
        return jpaScheduleRepository.findById(scheduleId).orElseThrow(() -> new GenericErrorException("Can't create or update Finca-Schedule relation. Schedule '" + scheduleId + "' not found."));
    }
}
