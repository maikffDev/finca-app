package com.finca.app.application.usecases.discount;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.in.discount.CreateDiscountUseCase;
import com.finca.app.domain.ports.out.DiscountModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateDiscountUseCaseImpl implements CreateDiscountUseCase {
    private final DiscountModelPort discountModelPort;

    public CreateDiscountUseCaseImpl(DiscountModelPort discountModelPort){this.discountModelPort = discountModelPort;}

    @Override
    public Discount create(Discount discount){return discountModelPort.save(discount);}
}
