package com.finca.app.domain.ports.in.reservation;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.domain.models.Reservation;

public interface CreateReservationUseCase {
    Reservation create(ReservationDTORequest reservation);
}
