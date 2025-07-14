package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.FincaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaFincaRepository extends JpaRepository<FincaEntity, Long> {
    boolean existsByName(String name);
    boolean existsByUbication (String ubication);
    Optional<FincaEntity> findByUser_Username(String username);
}
