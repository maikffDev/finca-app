package com.finca.app.application.service.Discount;

import com.finca.app.application.dto.discount.DiscountDTORequest;
import com.finca.app.application.dto.discount.DiscountDTOResponse;
import com.finca.app.domain.models.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    DiscountDTOResponse create(DiscountDTORequest discountDto);

     DiscountDTOResponse delete(Long id);

     List<DiscountDTOResponse> getAll();

     DiscountDTOResponse getById(Long id);

     DiscountDTOResponse getByName(String name);

     DiscountDTOResponse getByDiscountPercentage(Double discountPercentage);

     DiscountDTOResponse update(Long id, DiscountDTORequest discountDTORequest);
}
