package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStateRepository extends JpaRepository<StateEntity, Long> {
}
