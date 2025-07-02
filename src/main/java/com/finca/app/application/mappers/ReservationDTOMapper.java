package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.service.hourhand.impl.HourHandModelService;
import com.finca.app.application.service.user.impl.UserModelService;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Reservation;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class ReservationDTOMapper {


    @Autowired
    UserModelService userModelService;
    @Autowired
    HourHandModelService hourHandModelService;

    public abstract Reservation toModel(ReservationDTORequest reservationDto);

    public abstract ReservationDTOResponse toDto(Reservation reservation);

    public abstract List<ReservationDTOResponse> toDtoList(List<Reservation> reservations);

}
