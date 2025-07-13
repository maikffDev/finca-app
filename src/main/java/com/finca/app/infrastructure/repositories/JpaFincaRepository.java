package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.FincaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaFincaRepository extends JpaRepository<FincaEntity, Long> {

    @Query("""
       SELECT DISTINCT f
       FROM FincaEntity  f
         JOIN f.availableSchedules s
       WHERE s.reserved = false
         AND f.active   = true
       """)
    List<FincaEntity> findAllActiveWithFreeHourHand();

    boolean existsByName(String name);
    boolean existsByUbication (String ubication);
    Optional<FincaEntity> findByUser_Username(String username);
}
