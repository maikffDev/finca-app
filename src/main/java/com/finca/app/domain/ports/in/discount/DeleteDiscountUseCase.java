package com.finca.app.domain.ports.in.discount;

import com.finca.app.domain.models.Discount;

public interface DeleteDiscountUseCase {
    Boolean delete(Long id);

}
