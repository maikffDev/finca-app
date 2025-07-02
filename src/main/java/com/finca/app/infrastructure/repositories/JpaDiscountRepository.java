package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaDiscountRepository extends JpaRepository<DiscountEntity, Long> {
    Optional<DiscountEntity> findByName(String name);

    Optional<DiscountEntity> findByDiscountPercentage(Double discountPercentage);
}
