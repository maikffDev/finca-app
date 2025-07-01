package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.ReservationEntity;
import com.finca.app.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<ReservationEntity, Long>  {


}
