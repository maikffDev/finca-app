package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;

public interface TicketModelPort {

    Ticket save(Ticket ticket);

    Ticket generateNewTicket(Reservation reservation);
}
