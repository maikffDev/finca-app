package com.finca.app.application.service.discount.impl;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.in.discount.CreateDiscountUseCase;
import com.finca.app.domain.ports.in.discount.DeleteDiscountUseCase;
import com.finca.app.domain.ports.in.discount.FindDiscountUseCase;
import com.finca.app.domain.ports.in.discount.UpdateDiscountUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountModelService implements CreateDiscountUseCase, DeleteDiscountUseCase, UpdateDiscountUseCase, FindDiscountUseCase {
    private final CreateDiscountUseCase createDiscountUseCase;
    private final DeleteDiscountUseCase deleteDiscountUseCase;
    private final UpdateDiscountUseCase updateDiscountUseCase;
    private final FindDiscountUseCase findDiscountUseCase;

    public DiscountModelService(CreateDiscountUseCase createDiscountUseCase, DeleteDiscountUseCase deleteDiscountUseCase, UpdateDiscountUseCase updateDiscountUseCase, FindDiscountUseCase findDiscountUseCase) {
        this.createDiscountUseCase = createDiscountUseCase;
        this.deleteDiscountUseCase = deleteDiscountUseCase;
        this.updateDiscountUseCase = updateDiscountUseCase;
        this.findDiscountUseCase = findDiscountUseCase;
    }

    @Override
    public Discount create(Discount discount){ return createDiscountUseCase.create(discount); }

    @Override
    public Boolean delete(Long id){ return deleteDiscountUseCase.delete(id);}

    @Override
    public List<Discount> getAll(){return findDiscountUseCase.getAll();}

    @Override
    public Optional<Discount> getById(Long id){ return findDiscountUseCase.getById(id);}

    @Override
    public Optional<Discount> getByName(String name){ return findDiscountUseCase.getByName(name);}

    @Override
    public Optional<Discount> getByDiscountPercentage(Double discountPercentage){ return findDiscountUseCase.getByDiscountPercentage(discountPercentage);}

    @Override
    public Discount update(Discount discount){ return updateDiscountUseCase.update(discount);}
}
