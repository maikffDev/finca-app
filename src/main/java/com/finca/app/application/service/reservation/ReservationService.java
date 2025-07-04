package com.finca.app.application.service.reservation;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.dto.reservation.ReservationDTOResponse2;

import java.util.List;

public interface ReservationService {
    ReservationDTOResponse create(ReservationDTORequest2 ReservationDto);

    List<ReservationDTOResponse> getAll();

    ReservationDTOResponse getById(Long id);

    ReservationDTOResponse update(Long ReservationId, ReservationDTORequest ReservationDtoToUpdate);

    ReservationDTOResponse delete(Long id);

    ReservationDTOResponse logicalDeletion(Long id);



}
