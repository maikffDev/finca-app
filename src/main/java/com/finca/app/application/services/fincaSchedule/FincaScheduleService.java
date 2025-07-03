package com.finca.app.application.services.fincaSchedule;

import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTORequest;
import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTOResponse;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;

import java.util.List;

public interface FincaScheduleService {

    FincaScheduleDTOResponse create(FincaScheduleDTORequest fincaScheduleDTORequest);

    List<FincaScheduleDTOResponse> getAll();

    FincaScheduleDTOResponse getById(Long id);

    FincaScheduleDTOResponse update(Long fincaScheduleId, FincaScheduleDTORequest fincaScheduleDtoToUpdate);

    FincaScheduleDTOResponse delete(Long id);

    FincaScheduleDTOResponse logicalDeletion(Long id);

    List<ScheduleDTOResponse> getSchedulesByFincaId(Long fincaId);
}
