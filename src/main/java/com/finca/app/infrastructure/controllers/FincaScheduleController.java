package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTORequest;
import com.finca.app.application.dto.fincaSchedule.FincaScheduleDTOResponse;
import com.finca.app.application.dto.schedule.ScheduleDTOResponse;
import com.finca.app.application.services.fincaSchedule.FincaScheduleService;
import com.finca.app.domain.models.FincaSchedule;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Tag(name = "FincaSchedule", description = "Controller for FincaSchedule")
public class FincaScheduleController {
    private final FincaScheduleService fincaScheduleService;

    public FincaScheduleController(FincaScheduleService fincaScheduleService){
        this.fincaScheduleService = fincaScheduleService;
    }

    @PostMapping
    public ResponseEntity<FincaScheduleDTOResponse> create(@Valid @RequestBody FincaScheduleDTORequest fincaScheduleDto){
        return new ResponseEntity<>(fincaScheduleService.create(fincaScheduleDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<FincaScheduleDTOResponse> getAll(){
        return fincaScheduleService.getAll();
    }

    @GetMapping("/{id}")
    public FincaScheduleDTOResponse getById(@PathVariable("id") Long fincaScheduleId){
        return fincaScheduleService.getById(fincaScheduleId);
    }

    @PutMapping("/{id}")
    public FincaScheduleDTOResponse update(@PathVariable("id") Long fincaScheduleId, @RequestBody FincaScheduleDTORequest fincaScheduleToUpdate){
        return fincaScheduleService.update(fincaScheduleId, fincaScheduleToUpdate);
    }

    @DeleteMapping("/{id}")
    public FincaScheduleDTOResponse delete(@PathVariable("id") Long fincaScheduleId){
        return fincaScheduleService.delete(fincaScheduleId);
    }

    @DeleteMapping("/logicalDeletion/{id}")
    public FincaScheduleDTOResponse logicalDeletion(@PathVariable("id") Long fincaScheduleId){
        return fincaScheduleService.logicalDeletion(fincaScheduleId);
    }

    @GetMapping("getSchedulesByFincaId/{fincaId}")
    public List<ScheduleDTOResponse> getSchedulesByFincaId(@PathVariable("fincaId") Long fincaId){
        return fincaScheduleService.getSchedulesByFincaId(fincaId);
    }
}
