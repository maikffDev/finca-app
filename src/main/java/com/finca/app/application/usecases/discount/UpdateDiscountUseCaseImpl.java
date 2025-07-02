package com.finca.app.application.usecases.discount;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.in.discount.UpdateDiscountUseCase;
import com.finca.app.domain.ports.out.DiscountModelPort;

public class UpdateDiscountUseCaseImpl implements UpdateDiscountUseCase {

    private final DiscountModelPort discountModelPort;

    public UpdateDiscountUseCaseImpl(DiscountModelPort discountModelPort){ this.discountModelPort = discountModelPort;}

    @Override
    public Discount update(Discount discount){ return discountModelPort.update(discount);}
}
