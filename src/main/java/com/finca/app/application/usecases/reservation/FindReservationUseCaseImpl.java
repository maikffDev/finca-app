package com.finca.app.application.usecases.reservation;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.reservation.FindReservationUseCase;
import com.finca.app.domain.ports.out.ReservationModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindReservationUseCaseImpl implements FindReservationUseCase {

    private final ReservationModelPort reservationModelPort;

    public FindReservationUseCaseImpl(ReservationModelPort reservationModelPort) {
        this.reservationModelPort = reservationModelPort;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationModelPort.findAll();
    }

    @Override
    public Optional<Reservation> getByReservationID(Long reservationID) {
        return reservationModelPort.findByReservationID(reservationID);
    }

    @Override
    public Optional<Reservation> getByUserID(Long userID) {
        return reservationModelPort.findByUserId(userID);
    }

    ////REVISARRRRRR

}

