package com.finca.app.application.usecases.Reservation;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;
import com.finca.app.domain.ports.out.ReservationModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;

@Service
@Primary
public class CreateReservationUseCaseImpl implements CreateReservationUseCase {
    private final ReservationModelPort reservationModelPort;

    public CreateReservationUseCaseImpl(ReservationModelPort reservationModelPort) {this.reservationModelPort = reservationModelPort;}

    /*@Override
    public Reservation create(Reservation reservation) {
        return reservationModelPort.save(reservation);}*/

    @Override
    public Reservation create(ReservationDTORequest reservationDTO) {
        Reservation reservation= reservationModelPort.create(reservationDTO);
        reservation =reservationModelPort.save(reservation);
        return reservation;
    }
}
