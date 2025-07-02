package com.finca.app.application.mappers;

import com.finca.app.application.dto.schedule.ScheduleDTORequest;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;
import com.finca.app.domain.models.Schedule;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ScheduleDTOMapper {

    public abstract Schedule toModel(ScheduleDTORequest dto);

    public abstract ScheduleDTOResponse toDTO(Schedule model);

    public abstract List<ScheduleDTOResponse> toDTOList(List<Schedule> models);
}
