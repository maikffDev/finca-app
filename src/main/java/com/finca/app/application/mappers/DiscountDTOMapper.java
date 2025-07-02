package com.finca.app.application.mappers;

import com.finca.app.application.dto.discount.DiscountDTORequest;
import com.finca.app.application.dto.discount.DiscountDTOResponse;
import com.finca.app.domain.models.Discount;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public class DiscountDTOMapper {
    public abstract Discount toModel(DiscountDTORequest discountDto);

    public abstract DiscountDTOResponse toDto(Discount discount);

    public abstract List<DiscountDTOResponse> toDtoList(List<Discount> discounts);
}
