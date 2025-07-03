package com.finca.app.application.services.schedule;

import com.finca.app.application.dto.schedule.ScheduleDTORequest;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;

import java.util.List;

public interface ScheduleService {
    ScheduleDTOResponse create(ScheduleDTORequest request);
    List<ScheduleDTOResponse> getAll();
    ScheduleDTOResponse update(Long scheduleId, ScheduleDTORequest scheduleDTOToUpdate);
    ScheduleDTOResponse delete(Long id);
    ScheduleDTOResponse logicalDeletion(Long id);
}

