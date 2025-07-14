package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;
import com.finca.app.infrastructure.entities.ReservationEntity;
import com.finca.app.infrastructure.entities.TicketEntity;

public interface TicketModelPort {

    Ticket save(Ticket ticket);

    public TicketEntity save(TicketEntity ticket);

    Ticket generateNewTicket(Reservation reservation);

    Ticket generateNewTicket2(ReservationEntity reservation);
}
