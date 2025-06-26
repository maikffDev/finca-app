package com.finca.app.domain.ports.in.reservation;

import com.finca.app.domain.models.Reservation;

public interface UpDateReservationUseCase {
    Reservation update(Reservation reservation);
}
