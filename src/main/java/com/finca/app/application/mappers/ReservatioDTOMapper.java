package com.finca.app.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public class ReservatioDTOMapper {

    /* todo hacer imports correctos y corregir abstract del metodo.
    *  la idea del mapper es que el metodo sea publico para que se pueda usar en cualquier contexto
   */
    //TODO

    /*
    @Autowired
    UsuarioModelService userModelService;
    @Autowired
    HorarioModelService horarioModelService;
    @Autowired
    UsuarioModelService usuarioModelService;
    @Autowired
    TypeOfSeasonService typeOfSeasonService;


    @Mapping(source = "user_id", target = "user", qualifiedByName = "mapUserIdToUser")
    public abstract Reservation toModel(ReservationDTORequest reservationDto);
    */
}
