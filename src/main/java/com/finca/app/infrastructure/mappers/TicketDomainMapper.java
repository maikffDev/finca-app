package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Ticket;
import com.finca.app.infrastructure.entities.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class TicketDomainMapper {
    @Mapping(source = "paymentMethod", target = "paymentMethod")
    public abstract TicketEntity toEntity(Ticket ticket);

    @Mapping(source = "paymentMethod", target = "paymentMethod")
    public abstract Ticket toDomain(TicketEntity ticketEntity);
}
