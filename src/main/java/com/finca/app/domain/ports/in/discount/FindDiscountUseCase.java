package com.finca.app.domain.ports.in.discount;

import com.finca.app.domain.models.Discount;

import java.util.List;
import java.util.Optional;

public interface FindDiscountUseCase {
    List<Discount> getAll();

    Optional<Discount> getById(Long id);

    Optional<Discount> getByName(String name);

    Optional<Discount> getByDiscountPercentage(Double discountPercentage);

}
