package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.schedule.ScheduleDTORequest;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;
import com.finca.app.application.service.schedule.ScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Schedule", description = "Controles for Schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleDTOResponse> create(@Valid @RequestBody ScheduleDTORequest scheduleDTORequest){
        return new ResponseEntity<>(scheduleService.create(scheduleDTORequest), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScheduleDTOResponse> getAll(){
        return scheduleService.getAll();
    }

    @PutMapping("/{id}")
    public ScheduleDTOResponse update(@PathVariable("id") Long scheduleId, @RequestBody ScheduleDTORequest scheduleToRequest){
        return scheduleService.update(scheduleId, scheduleToRequest);
    }

    @DeleteMapping("/{id}")
    public ScheduleDTOResponse delete(@PathVariable("id") Long scheduleId){
        return scheduleService.delete(scheduleId);
    }

    @DeleteMapping("/logicalDeletion/{id}")
    public ScheduleDTOResponse logicalDeletion(@PathVariable("id") Long scheduleId){
        return scheduleService.logicalDeletion(scheduleId);
    }
}
