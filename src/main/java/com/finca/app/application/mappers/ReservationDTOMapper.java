package com.finca.app.application.mappers;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.services.schedule.ScheduleService;
import com.finca.app.application.services.user.impl.UserModelService;
import com.finca.app.domain.models.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class ReservationDTOMapper {

    /* todo hacer imports correctos y corregir abstract del metodo.
    *  la idea del mapper es que el metodo sea publico para que se pueda usar en cualquier contexto
   */
    //TODO


    @Autowired
    UserModelService userModelService;
    @Autowired
    ScheduleService horarioModelService;
    @Autowired
    UserModelService usuarioModelService;

    @Mapping(source = "user_id", target = "user", qualifiedByName = "mapUserIdToUser")
    public abstract Reservation toModel(ReservationDTORequest reservationDto);

}
