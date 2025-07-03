package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTORequest;
import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTOResponse;
import com.finca.app.application.service.finca_HourHand.Finca_HourHandService;
import com.finca.app.infrastructure.exceptions.DomainValidationException;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finca-hour-hand")
public class Finca_HourHandController {

    private final Finca_HourHandService fincaHourHandService;

    public Finca_HourHandController(Finca_HourHandService fincaHourHandService) {
        this.fincaHourHandService = fincaHourHandService;
    }

    @PostMapping
    public ResponseEntity<Finca_HourHandDTOResponse> create(@Valid @RequestBody Finca_HourHandDTORequest dtoRequest) {
        try {
            return new ResponseEntity<>(fincaHourHandService.create(dtoRequest), HttpStatus.CREATED);
        } catch (DomainValidationException e) {
            throw new GenericErrorException("Validation error when creating Finca_HourHand: " + e.getMessage());
        } catch (Exception e) {
            throw new GenericErrorException("Internal error while creating Finca_HourHand: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Finca_HourHandDTOResponse getById(@PathVariable("id") Long id) {
        return fincaHourHandService.getById(id)
                .orElseThrow(() -> new GenericErrorException("Finca_HourHand with id '" + id + "' not found."));
    }

    @GetMapping
    public List<Finca_HourHandDTOResponse> getAll() {
        return fincaHourHandService.getAll();
    }

    @GetMapping("/by-finca/{fincaId}")
    public List<Finca_HourHandDTOResponse> getByFincaId(@PathVariable("fincaId") Long fincaId) {
        return fincaHourHandService.getByFincaId(fincaId);
    }

    @GetMapping("/by-hour-hand/{hourHandId}")
    public List<Finca_HourHandDTOResponse> getByHourHandId(@PathVariable("hourHandId") Long hourHandId) {
        return fincaHourHandService.getByHourHandId(hourHandId);
    }

    @PutMapping("/{id}")
    public Finca_HourHandDTOResponse update(@PathVariable("id") Long id, @RequestBody Finca_HourHandDTORequest dtoRequest) {
        return fincaHourHandService.update(id, dtoRequest);
    }

    @DeleteMapping("/{id}")
    public Finca_HourHandDTOResponse delete(@PathVariable("id") Long id) {
        return fincaHourHandService.delete(id);
    }
}
