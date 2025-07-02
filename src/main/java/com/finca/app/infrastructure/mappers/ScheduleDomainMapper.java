package com.finca.app.infrastructure.mappers;

import com.finca.app.application.util.GenericErrorException;
import com.finca.app.domain.models.Schedule;

import com.finca.app.infrastructure.entities.ScheduleEntity;
import com.finca.app.infrastructure.repositories.JpaScheduleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScheduleDomainMapper {
    @Autowired
    public JpaScheduleRepository jpaScheduleRepository;

    @Mapping(source = "fincaSchedule.id", target = "fincaSchedule", qualifiedByName = "mapFincaScheduleIdToFincaSchedule")
    public abstract ScheduleEntity fromDomainModel(Schedule model);

    @Mapping(source = "fincaSchedule", target = "fincaSchedule")
    public abstract Schedule toDomainModel(ScheduleEntity scheduleEntity);

    public abstract List<ScheduleEntity> fromDomainModelList(List<Schedule> schedules);

    @Named("mapFincaScheduleIdToFincaSchedule")
    protected FincaScheduleEntity mapFincaScheduleIdToFincaSchedule(Long fincaScheduleId){
        return jpaFincaScheduleRepository.findById(fincaScheduleId).orElseThrow(() -> new GenericErrorException("Can't create or update Schedule. FincaSchedule '" + fincaScheduleId + "' not found."));
    }
}
