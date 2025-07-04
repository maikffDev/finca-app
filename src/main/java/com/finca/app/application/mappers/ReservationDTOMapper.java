package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.service.hourhand.impl.HourHandModelService;
import com.finca.app.application.service.user.impl.UserModelService;
import com.finca.app.domain.models.*;
import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import com.finca.app.infrastructure.repositories.JpaFincaHourHandRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Mapper(componentModel = "spring")
public abstract class ReservationDTOMapper {

    @Autowired
    JpaFincaHourHandRepository fincaHourHandRepository;


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

    /*public Reservation fromDTOtoNewModel(BigDecimal totalCostOfModel, ReservationDTORequest2 reservationDTORequest2, User user){



        return  Reservation.builder()
                .fincaHourHand()
                .userID(user)
                .on(true)
                .expiration(fincasHourHand.getLast().getHourHand().getDate())
                .ticket(null)
                .states(new LinkedList<>())
                .totalCost(totalCostOfModel)
                .build();

    };*/



   /* public Reservation fromDTOtoNewModel(ReservationDTORequest reservationDto, BigDecimal totalCostOfModel, List<FincaHourHandEntity> fincasHourHand, User user){

        return  Reservation.builder()
                .fincaHourHand(fincasHourHand)
                .userID(user)
                .on(true)
                .expiration(fincasHourHand.getLast().getHourHandEntity().getDate())
                .ticket(null)
                .states(new LinkedList<>())
                .totalCost(totalCostOfModel)
                .build();

    };*/

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

    public Reservation fromDTOtoNewModel(BigDecimal total, User user, LocalDate expiration) {

        return  Reservation.builder()
                .userID(user)
                .on(true)
                .expiration(expiration)
                .ticket(null)
                .states(new LinkedList<>())
                .totalCost(total)
                .build();
    }


}
