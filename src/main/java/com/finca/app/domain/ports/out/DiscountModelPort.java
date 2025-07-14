package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountModelPort {
    Discount save(Discount discount);

    Boolean delete(Long id);

    List<Discount> findAll();

    Optional<Discount> findById(Long id);

    Optional<Discount> findByName(String name);

    Optional<Discount> findByDiscountPercentage(Double discountPercentage);

    Discount update(Discount discount);

}
