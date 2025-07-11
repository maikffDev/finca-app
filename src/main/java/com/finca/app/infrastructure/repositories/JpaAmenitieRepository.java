package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.AmenitieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAmenitieRepository extends JpaRepository<AmenitieEntity, Long> {
}