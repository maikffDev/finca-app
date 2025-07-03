package com.finca.app.infrastructure.mappers;

import com.finca.app.application.mappers.FincaHourHandMapper;
import com.finca.app.domain.models.Reservation;
import com.finca.app.infrastructure.entities.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FincaHourHandMapper.class, UserDomainMapper.class, TicketDomainMapper.class})
public abstract class ReservationDomainMapper {

    @Mapping(source = "reservationID", target = "id")
    @Mapping(source = "fincaHourHand", target = "fincaHourHandEntity")
    @Mapping(source = "userID", target = "userEntity")
    @Mapping(source = "on", target = "active")
    @Mapping(source = "expiration", target = "expirationDate")
    @Mapping(source = "ticket", target = "ticketEntity")
    @Mapping(source = "states", target = "stateHistoryEntity")
    public abstract ReservationEntity fromModelToEntity(Reservation reservation);

    @Mapping(source = "id", target = "reservationID")
    @Mapping(source = "fincaHourHandEntity", target = "fincaHourHand")
    @Mapping(source = "userEntity", target = "userID")
    @Mapping(source = "active", target = "on")
    @Mapping(source = "expirationDate", target = "expiration")
    @Mapping(source = "ticketEntity", target = "ticket")
    @Mapping(source = "stateHistoryEntity", target = "states")
    public abstract Reservation fromEntityToModel(ReservationEntity reservationEntity);

}
