package com.finca.app.domain.ports.out;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;
import com.finca.app.infrastructure.entities.ReservationEntity;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface ReservationModelPort {
    Reservation save(Reservation reservation);

    Boolean delete(Long id);

    List<Reservation> findAll();

    Optional<Reservation> findByReservationID(Long userID);

    Reservation logicalDeletion(Reservation reservation);

    Optional<Reservation> findByUserId(Long id);

    Reservation update(Reservation reservation);

    Reservation create(ReservationDTORequest2 reservation);

    Reservation addTicketToReservation(Reservation reservation, Ticket ticket);

    ReservationEntity addTicketToReservation(ReservationEntity reservation, Ticket ticket);

    ReservationEntity validateReservation (Reservation reserve, ReservationDTORequest2 reservationEntity);

    Reservation save(@NotNull ReservationEntity reservationEntity);

    ReservationEntity save2(@NotNull ReservationEntity reservationEntity);
}
