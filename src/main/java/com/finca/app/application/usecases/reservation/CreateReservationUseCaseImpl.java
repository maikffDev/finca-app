package com.finca.app.application.usecases.reservation;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.out.ReservationModelPort;
import org.springframework.stereotype.Service;
import com.finca.app.domain.ports.in.Reservation.CreateReservationUseCase;

@Service
public class CreateReservationUseCaseImpl implements CreateReservationUseCase {
    private final ReservationModelPort reservationModelPort;

    public CreateReservationUseCaseImpl(ReservationModelPort reservationModelPort) {this.reservationModelPort = reservationModelPort;}

    @Override
    public Reservation create(Reservation reservation) {return reservationModelPort.save(reservation);}
}
