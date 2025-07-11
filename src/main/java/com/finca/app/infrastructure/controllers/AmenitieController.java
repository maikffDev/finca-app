package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.amenitie.AmenitieDTORequest;
import com.finca.app.application.dto.amenitie.AmenitieDTOResponse;
import com.finca.app.application.service.amenitie.AmenitieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
@Tag(name = "Amenitie", description = "Controller for Amenities")
public class AmenitieController {

    private final AmenitieService amenitieService;

    public AmenitieController(AmenitieService amenitieService) {
        this.amenitieService = amenitieService;
    }

    @PostMapping
    public ResponseEntity<AmenitieDTOResponse> create(@Valid @RequestBody AmenitieDTORequest request) {
        AmenitieDTOResponse createdAmenitie = amenitieService.create(request);
        return new ResponseEntity<>(createdAmenitie, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AmenitieDTOResponse>> getAll() {
        List<AmenitieDTOResponse> amenities = amenitieService.getAll();
        return ResponseEntity.ok(amenities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenitieDTOResponse> getById(@PathVariable Long id) {
        return amenitieService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (amenitieService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}