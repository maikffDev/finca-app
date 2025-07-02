package com.finca.app.application.usecases.discount;

import com.finca.app.application.usecases.finca.FindFincaUseCaseImpl;
import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.in.discount.FindDiscountUseCase;
import com.finca.app.domain.ports.out.DiscountModelPort;
import com.finca.app.domain.ports.out.FincaModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class FindDiscountUseCaseImpl implements FindDiscountUseCase {

    private final DiscountModelPort discountModelPort;

    public FindDiscountUseCaseImpl(DiscountModelPort discountModelPort){ this.discountModelPort = discountModelPort;}

    @Override
    public List<Discount> getAll(){return discountModelPort.findAll();}

    @Override
    public Optional<Discount> getById(Long id){return discountModelPort.findById(id);}

    @Override
    public Optional<Discount> getByName(String name){ return discountModelPort.findByName(name);}

    @Override
    public Optional<Discount> getByDiscountPercentage(Double discountPercentage) {return Optional.empty();};
    /*@Override
    public Optional<Discount> getBydiscountPercentage(Double discountPercentage){ return discountModelPort.findByDiscountPercentage(discountPercentage); };*/
}
