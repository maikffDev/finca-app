package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.Finca_HourHandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JpaFinca_HourHandRepository extends JpaRepository<Finca_HourHandEntity, Long> {

    List<Finca_HourHandEntity> findByFincaId(Long fincaId);

    List<Finca_HourHandEntity> findByHourHandId(Long hourHandId);
}

