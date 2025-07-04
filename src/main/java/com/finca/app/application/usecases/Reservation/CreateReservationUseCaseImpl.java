package com.finca.app.application.usecases.Reservation;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;
import com.finca.app.domain.ports.out.ReservationModelPort;
import com.finca.app.domain.ports.out.TicketModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;

@Service
@Primary
public class CreateReservationUseCaseImpl implements CreateReservationUseCase {
    private final ReservationModelPort reservationModelPort;
    private final TicketModelPort ticketModelPort;

    public CreateReservationUseCaseImpl(ReservationModelPort reservationModelPort, TicketModelPort ticketModelPort) {
        this.reservationModelPort = reservationModelPort;
        this.ticketModelPort = ticketModelPort;
    }

    /*@Override
    public Reservation create(Reservation reservation) {
        return reservationModelPort.save(reservation);}*/

    @Override
    public Reservation create(ReservationDTORequest reservationDTO) {
        Reservation reservation= reservationModelPort.create(reservationDTO);
        reservation =reservationModelPort.save(reservation);
        System.out.println("PASO a generar el ticket");
        System.out.println("PASO a generar el ticket");
        System.out.println("PASO a generar el ticket");
        Ticket ticket=ticketModelPort.generateNewTicket(reservation); //TODO hace que se llame al caso de uso, y no al model port
        reservation= reservationModelPort.addTicketToReservation(reservation,ticket);
        reservation =reservationModelPort.save(reservation);
        return reservation;
    }
}
