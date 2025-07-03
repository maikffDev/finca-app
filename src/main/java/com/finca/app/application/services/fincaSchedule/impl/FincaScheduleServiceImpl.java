package com.finca.app.application.services.fincaSchedule.impl;

import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTORequest;
import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTOResponse;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;
import com.finca.app.application.mappers.FincaScheduleDTOMapper;
import com.finca.app.application.mappers.ScheduleDTOMapper;
import com.finca.app.application.services.fincaSchedule.FincaScheduleService;
import com.finca.app.application.util.GenericErrorException;
import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FincaScheduleServiceImpl implements FincaScheduleService {
    
    private final FincaScheduleModelService fincaScheduleModelService;
    private final FincaScheduleDTOMapper fincaScheduleDTOMapper;
    private final ScheduleDTOMapper scheduleDTOMapper;

    public FincaScheduleServiceImpl(FincaScheduleModelService fincaScheduleModelService, FincaScheduleDTOMapper fincaScheduleDTOMapper, ScheduleDTOMapper scheduleDTOMapper){
        this.fincaScheduleModelService = fincaScheduleModelService;
        this.fincaScheduleDTOMapper = fincaScheduleDTOMapper;
        this.scheduleDTOMapper = scheduleDTOMapper;
    }

    @Override
    public FincaScheduleDTOResponse create(FincaScheduleDTORequest fincaScheduleDto){
        fincaScheduleDto.setEnabled(true);
        FincaSchedule fincaSchedule = fincaScheduleDTOMapper.toModel(fincaScheduleDto);
        FincaSchedule newFincaSchedule = fincaScheduleModelService.create(fincaSchedule);
        return fincaScheduleDTOMapper.toDto(newFincaSchedule);
    }

    @Override
    public List<FincaScheduleDTOResponse> getAll(){
        List<FincaSchedule> fincaSchedules = fincaScheduleModelService.getAll();
        if (fincaSchedules.isEmpty()){
            throw new GenericErrorException("No fincaSchedules were found in the database.");
        }
        return fincaScheduleDTOMapper.toDtoList(fincaSchedules);
    }
    
    @Override
    public FincaScheduleDTOResponse getById(Long id){
        FincaSchedule fincaSchedule = fincaScheduleModelService.getById(id).orElseThrow(() -> new GenericErrorException("FincaSchedule with id '" + id + "' not found"));
        return fincaScheduleDTOMapper.toDto(fincaSchedule);
    }

    @Override
    public FincaScheduleDTOResponse update(Long fincaScheduleId, FincaScheduleDTORequest fincaScheduleDto){
        FincaSchedule fincaSchedule = fincaScheduleModelService.getById(fincaScheduleId).orElseThrow(() -> new GenericErrorException("CANNOT UPDATE. FincaSchedule with id '" + fincaScheduleId + "' not found."));
        FincaSchedule fincaScheduleToUpdate = fincaScheduleDTOMapper.toModel(fincaScheduleDto);
        fincaSchedule.setFinca(fincaScheduleToUpdate.getFinca());
        fincaSchedule.setSchedule(fincaScheduleToUpdate.getSchedule());
        fincaSchedule.setEnabled(fincaScheduleToUpdate.getEnabled());
        FincaSchedule updatedFincaSchedule = fincaScheduleModelService.update(fincaSchedule);
        return fincaScheduleDTOMapper.toDto(updatedFincaSchedule);
    }

    @Override
    public FincaScheduleDTOResponse delete(Long id){
        FincaSchedule fincaSchedule = fincaScheduleModelService.getById(id).orElseThrow(() -> new GenericErrorException("CANNOT DELETE. FincaSchedule with id '" + id + "' not found."));
        Boolean isDelete = fincaScheduleModelService.delete(id);
        if (isDelete == true){
            return fincaScheduleDTOMapper.toDto(fincaSchedule);
        }
        throw new GenericErrorException("CANNOT DELETE. Domething went wrong during the process. Try again.");
    }

    @Override
    public FincaScheduleDTOResponse logicalDeletion(Long id){
        FincaSchedule fincaSchedule = fincaScheduleModelService.getById(id).orElseThrow(() -> new GenericErrorException("CANNOT DISABLE. FincaSchedule with id '" + id + "' not found."));
        fincaSchedule.setEnabled(false);
        FincaSchedule disableFincaSchedule = fincaScheduleModelService.logicalDeletion(fincaSchedule);
        return fincaScheduleDTOMapper.toDto(disableFincaSchedule);
    }

    @Override
    public List<ScheduleDTOResponse> getSchedulesByFincaId(Long fincaId){
        List<Schedule> schedules = fincaScheduleModelService.getSchedulesByFincaId(fincaId);
        if (schedules.isEmpty()){
            throw new GenericErrorException("No schedules were found in the database for fincaId '" + fincaId + "'.");
        }
        return schedules.stream().map(schedule -> scheduleDTOMapper.toDto(schedule)).collect(Collectors.toList());
    }
}
