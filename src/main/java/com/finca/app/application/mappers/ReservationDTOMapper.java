package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.service.hourhand.impl.HourHandModelService;
import com.finca.app.application.service.user.impl.UserModelService;
import com.finca.app.domain.models.*;
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

    public Reservation fromDTOtoNewModel(ReservationDTORequest reservationDto, BigDecimal totalCostOfModel, List<Finca_HourHand> fincasHourHand, User user){

        return  Reservation.builder()
                .fincaHourHand(fincasHourHand)
                .userID(user)
                .on(true)
                .expiration(fincasHourHand.getLast().getHourHand().getDate())
                .ticket(null)
                .states(new LinkedList<>())
                .totalCost(totalCostOfModel)
                .build();

    };

    public Reservation fromDTOtoNewModel(ReservationDTORequest reservationDto, BigDecimal totalCostOfModel, Finca_HourHand fincasHourHand, User user){

        LinkedList<Finca_HourHand> finquitasHoritas= new LinkedList<>();
        finquitasHoritas.add(fincasHourHand);


        return  Reservation.builder()
                .fincaHourHand(finquitasHoritas)
                .userID(user)
                .on(true)
                .expiration(fincasHourHand.getHourHand().getDate())
                .ticket(null)
                .states(new LinkedList<>())
                .totalCost(totalCostOfModel)
                .build();

    };


}
