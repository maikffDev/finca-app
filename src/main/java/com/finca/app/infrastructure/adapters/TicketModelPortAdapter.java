package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;
import com.finca.app.domain.ports.out.TicketModelPort;
import com.finca.app.infrastructure.entities.ReservationEntity;
import com.finca.app.infrastructure.entities.TicketEntity;
import com.finca.app.infrastructure.mappers.TicketDomainMapper;
import com.finca.app.infrastructure.repositories.JpaTicketRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class TicketModelPortAdapter implements TicketModelPort {


    private final JpaTicketRepository jpaTicketRepository;
    private final TicketDomainMapper ticketDomainMapper;

    public TicketModelPortAdapter(JpaTicketRepository jpaTicketRepository, TicketDomainMapper ticketDomainMapper) {
        this.jpaTicketRepository = jpaTicketRepository;
        this.ticketDomainMapper = ticketDomainMapper;
    }

    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity ticketEntity = ticketDomainMapper.toEntity(ticket);
        ticketEntity =jpaTicketRepository.save(ticketEntity);
        return ticketDomainMapper.toDomain(ticketEntity);
    }

    @Override
    public TicketEntity save(TicketEntity ticket) {
        TicketEntity ticketEntity =jpaTicketRepository.save(ticket);
        return ticketEntity;
    }

    @Override
    public Ticket generateNewTicket(@NotNull Reservation reservation) {

        System.out.println("Mostrando el Reservation que llego a generateNewTicket");
        System.out.println("Mostrando el Reservation que llego a generateNewTicket");
        System.out.println(reservation);
        System.out.println("Mostrando el Reservation que llego a generateNewTicket");
        System.out.println("Mostrando el Reservation que llego a generateNewTicket");


        LocalTime firstDayOfReservation=reservation.getFincaHourHand().getFirst().getHourHand().getArrivalTime();
        Ticket ticket =Ticket.builder()
                .total(reservation.getTotalCost().doubleValue())
                .paymentMethod("efectivo")
                .paymentDate(LocalDate.from(firstDayOfReservation))
                .build();

        return save(ticket);
    }

    @Override
    public Ticket generateNewTicket2(ReservationEntity reservation) {

        System.out.println("Mostrando el Reservation que llego a generateNewTicket2");
        System.out.println("Mostrando el Reservation que llego a generateNewTicket2");
        System.out.println(reservation);
        System.out.println("Mostrando el Reservation que llego a generateNewTicket2");
        System.out.println("Mostrando el Reservation que llego a generateNewTicket2");

        LocalDate firstDayOfReservation=reservation.getFincaHourHandEntity().getFirst().getHourHandEntity().getDate();
        Ticket ticket =Ticket.builder()
                .total(reservation.getTotalCost().doubleValue())
                .paymentMethod("efectivo")
                .paymentDate(firstDayOfReservation)
                .build();

        return save(ticket);
    }

}
