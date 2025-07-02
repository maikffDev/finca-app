package com.finca.app.domain.ports.in.discount;

import com.finca.app.domain.models.Discount;

public interface CreateDiscountUseCase {
    Discount create(Discount discount);
}
