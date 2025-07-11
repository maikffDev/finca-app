package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.ImageEntity;
import com.finca.app.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaImageRepository extends JpaRepository<ImageEntity, Long> {
}
