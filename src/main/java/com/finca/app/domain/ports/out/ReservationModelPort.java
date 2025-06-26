package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationModelPort {
    Reservation save(Reservation reservation);

    Boolean delete(Long id);

    List<Reservation> findAll();

    Optional<Reservation> findByReservationID(Long userID);

    Reservation logicalDeletion(Reservation reservation);

    Optional<Reservation> findByUserId(Long id);

    Reservation update(Reservation reservation);
}
