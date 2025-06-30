package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.FincaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaFincaRepository extends JpaRepository<FincaEntity, Long> {
    boolean existsByName(String name);
    boolean existByUbication(String username);
    Optional<FincaEntity> findByUsername(String username);
}
