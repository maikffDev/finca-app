package com.finca.app.application.services.reservation;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;

import java.util.List;

public interface ReservationService {
    ReservationDTOResponse create(ReservationDTORequest ReservationDto);

    List<ReservationDTOResponse> getAll();

    ReservationDTOResponse getById(Long id);

    ReservationDTOResponse update(Long ReservationId, ReservationDTORequest ReservationDtoToUpdate);

    ReservationDTOResponse delete(Long id);

    ReservationDTOResponse logicalDeletion(Long id);

}
