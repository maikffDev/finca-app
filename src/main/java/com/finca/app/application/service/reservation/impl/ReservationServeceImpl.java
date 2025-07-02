package com.finca.app.application.service.reservation.impl;

import com.finca.app.application.mappers.ReservationDTOMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationServeceImpl implements ReservationModelService{

    private final ReservationModelService reservationModelService;
    private final ReservationDTOMapper reservationDTOMapper;

}

