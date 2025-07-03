package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.FincaScheduleEntity;
import com.finca.app.infrastructure.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaFincaScheduleRepository extends JpaRepository<FincaScheduleEntity, Long> {
    @Query("SELECT fs.schedule FROM FincaScheduleEntity fs WHERE fs.finca.id = :fincaId")
    List<ScheduleEntity> findScheduleByFincaId(@Param("fincaId") Long fincaId);
}
