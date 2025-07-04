package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaFincaHourHandRepository extends JpaRepository<FincaHourHandEntity, Long> {

    Optional<FincaHourHandEntity> findByFinca_IdAndHourHandEntity_Id(Long fincaId, Long hourHandId);


}
