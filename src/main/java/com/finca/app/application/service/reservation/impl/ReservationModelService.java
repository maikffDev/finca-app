package com.finca.app.application.service.reservation.impl;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;
import com.finca.app.domain.ports.in.reservation.DeleteReservationUseCase;
import com.finca.app.domain.ports.in.reservation.FindReservationUseCase;
import com.finca.app.domain.ports.in.reservation.UpdateReservationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationModelService implements CreateReservationUseCase, DeleteReservationUseCase, UpdateReservationUseCase, FindReservationUseCase {

    private final CreateReservationUseCase createReservationUseCase;
    private final DeleteReservationUseCase deleteReservationUseCase;
    private final UpdateReservationUseCase updateReservationUseCase;
    private final FindReservationUseCase findReservationUseCase;

    public ReservationModelService(CreateReservationUseCase createReservationUseCase, DeleteReservationUseCase deleteReservationUseCase, UpdateReservationUseCase updateReservationUseCase, FindReservationUseCase findReservationUseCase) {
        this.createReservationUseCase = createReservationUseCase;
        this.deleteReservationUseCase = deleteReservationUseCase;
        this.updateReservationUseCase = updateReservationUseCase;
        this.findReservationUseCase = findReservationUseCase;
    }

    @Override
    public Reservation create(Reservation Reservation) {
        return createReservationUseCase.create(Reservation);
    }

    @Override
    public Boolean delete(Long id) {
        return deleteReservationUseCase.delete(id);
    }

    @Override
    public Reservation logicalDeletion(Reservation Reservation) {
        return deleteReservationUseCase.logicalDeletion(Reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return findReservationUseCase.getAll();
    }

    @Override
    public Optional<Reservation> getByReservationID(Long reservationID) {
        return findReservationUseCase.getByReservationID(reservationID);
    }

    @Override
    public Optional<Reservation> getByUserID(Long userID) {
        return findReservationUseCase.getByUserID(userID);
    }


    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }
}
