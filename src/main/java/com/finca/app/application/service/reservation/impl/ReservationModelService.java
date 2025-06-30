package com.finca.app.application.service.reservation.impl;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;
import com.finca.app.domain.ports.in.reservation.DeleteReservationUseCase;
import com.finca.app.domain.ports.in.reservation.FindReservationUseCase;
import com.finca.app.domain.ports.in.reservation.UpDateReservationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class ReservationModelService implements CreateReservationUseCase, DeleteReservationUseCase, UpDateReservationUseCase, FindReservationUseCase {

    private final CreateReservationUseCase createReservationUseCase;
    private final DeleteReservationUseCase deleteReservationUseCase;
    private final UpDateReservationUseCase upDateReservationUseCase;
    private final FindReservationUseCase findReservationUseCase;

    public ReservationModelService(CreateReservationUseCase createReservationUseCase, DeleteReservationUseCase deleteReservationUseCase, UpDateReservationUseCase upDateReservationUseCase, FindReservationUseCase findReservationUseCase) {
        this.createReservationUseCase = createReservationUseCase;
        this.deleteReservationUseCase = deleteReservationUseCase;
        this.upDateReservationUseCase = upDateReservationUseCase;
        this.findReservationUseCase = findReservationUseCase;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return upDateReservationUseCase.update(reservation);
    }

    @Override
    public Reservation create(Reservation reservation) {
        return createReservationUseCase.create(reservation);
    }

    @Override
    public Boolean delete(Long id) {
        return deleteReservationUseCase.delete(id);
    }

    @Override
    public Reservation logicalDeletion(Reservation reservation) {
        return deleteReservationUseCase.logicalDeletion(reservation);
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
}
