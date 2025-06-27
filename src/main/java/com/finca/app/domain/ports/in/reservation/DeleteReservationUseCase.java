package com.finca.app.domain.ports.in.reservation;

import com.finca.app.domain.models.Reservation;

public interface DeleteReservationUseCase {

    Boolean delete(Long id);

    Reservation logicalDeletion( Reservation reservation);
}
