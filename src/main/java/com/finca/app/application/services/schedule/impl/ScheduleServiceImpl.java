package com.finca.app.application.services.schedule.impl;

import com.finca.app.application.dto.schedule.ScheduleDTORequest;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;
import com.finca.app.application.mappers.ScheduleDTOMapper;
import com.finca.app.application.services.schedule.ScheduleService;
import com.finca.app.application.services.util.GenericErrorException;

import com.finca.app.application.util.GenericNoContentException;
import com.finca.app.domain.models.Schedule;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleModelService scheduleModelService;
    private final ScheduleDTOMapper scheduleDTOMapper;

    public ScheduleServiceImpl(ScheduleModelService scheduleModelService, ScheduleDTOMapper scheduleDTOMapper) {
        this.scheduleModelService = scheduleModelService;
        this.scheduleDTOMapper = scheduleDTOMapper;
    }

    @Override
    public ScheduleDTOResponse create(ScheduleDTORequest request) {
        Schedule model = scheduleDTOMapper.toModel(request);
        Schedule created = scheduleModelService.create(model);
        return scheduleDTOMapper.toDto(created);
    }

    @Override
    public List<ScheduleDTOResponse> getAll() {
        List<Schedule> list = scheduleModelService.getAll();
        if (list.isEmpty()) {
            throw new GenericNoContentException("No HourHands found in the system.");
        }
        return scheduleDTOMapper.toDtoList(list);
    }

    public ScheduleDTOResponse getById(Long id) {
        Schedule model = scheduleModelService.getById(id)
                .orElseThrow(() -> new GenericNoContentException("Schedule with id '" + id + "' not found."));
        return scheduleDTOMapper.toDto(model);
    }

    @Override
    public ScheduleDTOResponse update(Long scheduleId, ScheduleDTORequest scheduleDto) {
        Schedule schedule = scheduleModelService.getById(scheduleId)
                .orElseThrow(() -> new GenericErrorException("CANNOT UPDATE. Schedule with id '" + scheduleId + "' not found."));
        Schedule scheduleToUpdate = scheduleDTOMapper.toModel(scheduleDto);
        schedule.setDate(scheduleToUpdate.getDate());
        schedule.setStartTime(scheduleToUpdate.getStartTime());
        schedule.setEndTime(scheduleToUpdate.getEndTime());
        Schedule updatedSchedule = scheduleModelService.update(schedule);
        return scheduleDTOMapper.toDto(updatedSchedule);
    }


    @Override
    public ScheduleDTOResponse delete(Long id) {
        Schedule schedule = scheduleModelService.getById(id)
                .orElseThrow(() -> new GenericErrorException("CANNOT DELETE. Schedule with id '" + id + "' not found."));
        Boolean isDelete = scheduleModelService.delete(id);
        if (isDelete == true) {
            return scheduleDTOMapper.toDto(schedule);
        }
            throw new GenericErrorException("CANNOT DELETE. Something went wrong.");
    }

    @Override
    public ScheduleDTOResponse logicalDeletion(Long id) {
        Schedule model = scheduleModelService.getById(id)
                .orElseThrow(() -> new GenericErrorException("CANNOT DISABLE. Schedule with id '" + id + "' not found."));
        model.setEndTime(null);
        Schedule disabled = scheduleModelService.logicalDeletion(model);
        return scheduleDTOMapper.toDto(disabled);
    }
}