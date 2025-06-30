package com.finca.app.application.usecases.Reservation;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.reservation.UpdateReservationUseCase;
import com.finca.app.domain.ports.out.ReservationModelPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateReservationUseCaseImpl implements UpdateReservationUseCase {
    private final ReservationModelPort reservationModelPort;

    public UpdateReservationUseCaseImpl(ReservationModelPort reservationModelPort){ this.reservationModelPort = reservationModelPort;}

    @Override
    public Reservation update(Reservation reservation){ return reservationModelPort.update(reservation);}
}
