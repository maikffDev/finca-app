package com.finca.app.application.usecases.Reservation;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;
import com.finca.app.domain.ports.out.ReservationModelPort;
import com.finca.app.domain.ports.out.TicketModelPort;
import com.finca.app.infrastructure.entities.ReservationEntity;
import com.finca.app.infrastructure.mappers.ReservationDomainMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;

@Service
@Primary
public class CreateReservationUseCaseImpl implements CreateReservationUseCase {
    private final ReservationModelPort reservationModelPort;
    private final ReservationDomainMapper reservationDomainMapper;
    private final TicketModelPort ticketModelPort;

    public CreateReservationUseCaseImpl(ReservationModelPort reservationModelPort, ReservationDomainMapper reservationDomainMapper, TicketModelPort ticketModelPort) {
        this.reservationModelPort = reservationModelPort;
        this.reservationDomainMapper = reservationDomainMapper;
        this.ticketModelPort = ticketModelPort;
    }


    @Override
    public Reservation create(ReservationDTORequest2 reservationDTO) {
        Reservation reservation= reservationModelPort.create(reservationDTO);

        System.out.println("Primer CREATE ");
        System.out.println(reservation);
        System.out.println("Primer CREATE ");

        ReservationEntity reservationEntity= reservationModelPort.validateReservation(reservation,reservationDTO);

        System.out.println("Segundo VALIDATE");
        System.out.println(reservationEntity);
        System.out.println("Segundo VALIDATE ");

        reservationEntity =reservationModelPort.save2(reservationEntity);

        System.out.println("Tercer SAVE");
        System.out.println(reservationEntity);
        System.out.println("Tercer SAVE ");


        System.out.println("---------------");

        System.out.println("PASO a generar el ticket");
        System.out.println("PASO a generar el ticket");
        System.out.println("PASO a generar el ticket");
        Ticket ticket=ticketModelPort.generateNewTicket2(reservationEntity); //TODO hace que se llame al caso de uso, y no al model port
        reservationEntity= reservationModelPort.addTicketToReservation(reservationEntity,ticket);
        ReservationEntity reservationEntityComplete = reservationModelPort.save2(reservationEntity);


        return reservationDomainMapper.fromEntityToModel(reservationEntityComplete);
    }
}
