package com.finca.app.infrastructure.repositories;


import com.finca.app.infrastructure.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    boolean existsByName(String name);
    Optional<ScheduleEntity> findByName(String name);
}
