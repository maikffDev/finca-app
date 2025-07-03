package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.out.DiscountModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountModelPortAdapter implements DiscountModelPort {


    @Override
    public Discount save(Discount discount) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public List<Discount> findAll() {
        return List.of();
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Discount> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Discount> findByDiscountPercentage(Double discountPercentage) {
        return Optional.empty();
    }

    @Override
    public Discount update(Discount discount) {
        return null;
    }
}
