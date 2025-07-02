package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Discount;
import com.finca.app.infrastructure.entities.DiscountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountDomainMapper {
    DiscountEntity fromDomainModel(Discount discount);

    Discount toDomainModel(DiscountEntity discountEntity);
}
