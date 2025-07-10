package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.services.finca.FincaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fincas")
@Tag(name = "Finca", description = "Controller for Fincas")
public class FincaController {
    private final FincaService fincaService;

    public FincaController(FincaService fincaService){
        this.fincaService = fincaService;
    }

    @PostMapping
    public ResponseEntity<FincaDTOResponse> create(@Valid @RequestBody FincaDTORequest fincaDto){
        return new ResponseEntity<>(fincaService.create(fincaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<FincaDTOResponse> getAll(){
        return fincaService.getAll();
    }

    @GetMapping("/{id}")
    public FincaDTOResponse getById(@PathVariable("id") Long fincaId){
        return fincaService.getById(fincaId);
    }

    @GetMapping("/getByUser/{username}")
    public FincaDTOResponse getByUsername(@PathVariable("username") String username){
        return fincaService.getByUser(username);
    }

    @PutMapping("/{id}")
    public FincaDTOResponse update(@PathVariable("id") Long fincaId, @RequestBody FincaDTORequest fincaToUpdate){
        return fincaService.update(fincaId, fincaToUpdate);
    }

    @DeleteMapping("/{id}")
    public FincaDTOResponse delete(@PathVariable("id") Long fincaId){
        return fincaService.delete(fincaId);
    }

    @DeleteMapping("/logicalDeletion/{id}")
    public FincaDTOResponse logicalDeletion(@PathVariable("id") Long fincaId){
        return fincaService.logicalDeletion(fincaId);
    }
}
