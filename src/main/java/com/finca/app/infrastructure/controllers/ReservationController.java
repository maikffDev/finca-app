package com.finca.app.infrastructure.controllers;


import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.service.reservation.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reservation")
@Tag(name = "Reservation", description = "Controller for Reservation")
public class ReservationController {

        private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationDTOResponse> create(@Valid @RequestBody ReservationDTORequest request) {
        ReservationDTOResponse created = reservationService.create(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /*@PostMapping
    public ResponseEntity<ReservationDTOResponse2> create2(@Valid @RequestBody ReservationDTORequest2 request) {
        ReservationDTOResponse2 created = reservationService.create2(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }*/

    @GetMapping
    public ResponseEntity<List<ReservationDTOResponse>> getAll() {
        List<ReservationDTOResponse> reservations = reservationService.getAll();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTOResponse> getById(@PathVariable Long userId) {
        ReservationDTOResponse reservation = reservationService.getById(userId);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTOResponse> update(@PathVariable Long id, @Valid @RequestBody ReservationDTORequest request) {
        ReservationDTOResponse updated = reservationService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationDTOResponse> delete(@PathVariable Long id) {
        ReservationDTOResponse deleted = reservationService.delete(id);
        return ResponseEntity.ok(deleted);
    }

}
