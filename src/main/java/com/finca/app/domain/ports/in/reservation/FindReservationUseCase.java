package com.finca.app.domain.ports.in.reservation;

import com.finca.app.domain.models.Reservation;

import java.util.List;
import java.util.Optional;

public interface FindReservationUseCase {
    List<Reservation> getAll();

    Optional<Reservation> getByReservationID(Long reservationID);

    Optional<Reservation> getByUserID(Long userID);

}
