package com.finca.app.application.services.reservation.impl;

import org.springframework.stereotype.Service;

@Service
public class ReservationServeceImpl implements ReservationModelService{

    private final ReservationModelService reservationModelService;
    private final ReservationDTOMapper reservationDTOMapper;

}

