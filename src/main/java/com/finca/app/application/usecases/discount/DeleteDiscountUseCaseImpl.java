package com.finca.app.application.usecases.discount;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.in.discount.DeleteDiscountUseCase;
import com.finca.app.domain.ports.out.DiscountModelPort;

public class DeleteDiscountUseCaseImpl implements DeleteDiscountUseCase {
    private final DiscountModelPort discountModelPort;

    public DeleteDiscountUseCaseImpl(DiscountModelPort discountModelPort) {
        this.discountModelPort = discountModelPort;
    }

    @Override
    public Boolean delete(Long id) {
        return discountModelPort.delete(id);
    }
}
