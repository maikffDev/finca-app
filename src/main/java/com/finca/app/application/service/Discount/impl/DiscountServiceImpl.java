package com.finca.app.application.service.Discount.impl;

import com.finca.app.application.dto.discount.DiscountDTORequest;
import com.finca.app.application.dto.discount.DiscountDTOResponse;
import com.finca.app.application.mappers.DiscountDTOMapper;
import com.finca.app.application.service.Discount.DiscountService;
import com.finca.app.application.service.util.GenericErrorException;
import com.finca.app.domain.models.Discount;
import com.finca.app.infrastructure.exceptions.GenericNoContentException;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountModelService discountModelService;
    private final DiscountDTOMapper discountDTOMapper;
    public DiscountServiceImpl(DiscountModelService discountModelService, DiscountDTOMapper discountDTOMapper) {
        this.discountModelService = discountModelService;
        this.discountDTOMapper = discountDTOMapper;
    }

    @Override
    public DiscountDTOResponse create(DiscountDTORequest discountDTO){
        Discount discount = discountDTOMapper.toModel(discountDTO);
        Discount newDiscount = discountModelService.create(discount);
        return discountDTOMapper.toDto(newDiscount);
    }

    @Override
    public List<DiscountDTOResponse> getAll(){
        List<Discount> discounts = discountModelService.getAll();
        if (discounts.isEmpty()){
            throw new GenericErrorException("No Discount were found in the database.");
        }
        return discountDTOMapper.toDtoList(discounts);
    }

    @Override
    public DiscountDTOResponse getById(Long id){
        Discount discount = discountModelService.getById(id).orElseThrow(()-> new GenericErrorException("Finca with id '" + id + "' not found."));
        return discountDTOMapper.toDto(discount);
    }

    @Override
    public DiscountDTOResponse getByName(String name){
        Discount discount = discountModelService.getByName(name).orElseThrow(()-> new GenericErrorException("Discount with name '" + name + "' not found."));
        return  discountDTOMapper.toDto(discount);
    }

    @Override
    public DiscountDTOResponse getByDiscountPercentage(Double discountPercentage){
        Discount discount = discountModelService.getByDiscountPercentage(discountPercentage).orElseThrow(()-> new GenericErrorException("Discount with Discount Percentage '" + discountPercentage + "' not found"));
        return  discountDTOMapper.toDto(discount);
    }

    @Override
    public DiscountDTOResponse update(Long id, DiscountDTORequest discountDTO){
        Discount discount = discountModelService.getById(id).orElseThrow(()-> new GenericErrorException("CANNOT UPDATE. Finca with id '" + id + "' not found." ));
        Discount discountUpdate = discountDTOMapper.toModel(discountDTO);
        discount.setName(discountUpdate.getName());
        discount.setDiscountPercentage(discountUpdate.getDiscountPercentage());
        Discount updateDiscount = discountModelService.update(discount);
        return discountDTOMapper.toDto(updateDiscount);
    }

    @Override
    public DiscountDTOResponse delete(Long id){
        Discount discount = discountModelService.getById(id).orElseThrow(()-> new GenericErrorException("CANNOT DELETE. Finca with id '" + id + "' not found."));
        Boolean isDelete = discountModelService.delete(id);
        if (isDelete = true){
            return discountDTOMapper.toDto(discount);
        }
        throw  new GenericErrorException("CANNOT DELETE. Something went wrong during the process. Try again.");
    }

}
