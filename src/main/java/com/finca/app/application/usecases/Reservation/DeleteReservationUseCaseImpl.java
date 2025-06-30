package com.finca.app.application.usecases.Reservation;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.reservation.DeleteReservationUseCase;
import com.finca.app.domain.ports.out.ReservationModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteReservationUseCaseImpl implements DeleteReservationUseCase {
    private final ReservationModelPort reservationModelPort;

    public DeleteReservationUseCaseImpl(ReservationModelPort reservationModelPort) {
        this.reservationModelPort = reservationModelPort;
    }

    @Override
    public Boolean delete(Long id) {
        return reservationModelPort.delete(id);
    }

    @Override
    public Reservation logicalDeletion(Reservation reservation) {
        return reservationModelPort.logicalDeletion(reservation);
    }
}

