package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.service.hourhand.impl.HourHandModelService;
import com.finca.app.application.service.user.impl.UserModelService;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.Ticket;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


@Mapper(componentModel = "spring")
public abstract class ReservationDTOMapper {


   /* @Autowired
    UserModelService userModelService;
    @Autowired
    HourHandModelService hourHandModelService;*/


    public abstract Reservation toModel(ReservationDTORequest reservationDto);

    public abstract ReservationDTOResponse toDto(Reservation reservation);

    public abstract List<ReservationDTOResponse> toDtoList(List<Reservation> reservations);

    public Reservation fromDTOtoNewModel(ReservationDTORequest reservationDto, BigDecimal totalCostOfModel,List<Finca_HourHand> fincasHourHand){

        return  Reservation.builder()
                .fincaHourHand(fincasHourHand)
                .userID(reservationDto.getUser())
                .on(true)
                .expiration(fincasHourHand.getLast().getHourHand().getDate())
                .ticket(new Ticket())
                .states(new LinkedList<>())
                .totalCost(totalCostOfModel)
                .build();

    };


}
