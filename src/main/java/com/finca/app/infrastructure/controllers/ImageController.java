package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.image.ImageDTORequest;
import com.finca.app.application.dto.image.ImageDTOResponse;
import com.finca.app.application.mappers.ImageDTOMapper;
import com.finca.app.application.service.image.ImageService;
import com.finca.app.domain.models.Image;
import com.finca.app.domain.ports.out.ImageModelPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    /*
    @PostMapping
    public ResponseEntity<ImageDTOResponse> create(@RequestParam("fincaId") Long fincaId, @RequestParam("urlImage") String urlImage) {

        ImageDTOResponse created = imageService.create(fincaId, urlImage);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = imageService.delete(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTOResponse> getById(@PathVariable Long id) {
        ImageDTOResponse response = imageService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ImageDTOResponse> update(@RequestBody @Valid ImageDTORequest imageToUpdate) {
        ImageDTOResponse updated = imageService.update(imageToUpdate);
        return ResponseEntity.ok(updated);
    }
}
