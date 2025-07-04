package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {
}
