package com.finca.app.infrastructure.repositories;


import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import com.finca.app.infrastructure.entities.HourHandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaHourHandRepository extends JpaRepository<HourHandEntity, Long> {

   // Optional<FincaHourHandEntity> findByFinca_IdAndHourHand_Id(Long fincaId, Long hourHandId);

}
