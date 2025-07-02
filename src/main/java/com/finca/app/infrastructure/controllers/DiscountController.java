package com.finca.app.infrastructure.controllers;

import com.finca.app.application.dto.discount.DiscountDTORequest;
import com.finca.app.application.dto.discount.DiscountDTOResponse;
import com.finca.app.application.service.Discount.DiscountService;
import com.finca.app.infrastructure.exceptions.DomainValidationException;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService){
        this.discountService = discountService;
    }

    @PostMapping
    public ResponseEntity<DiscountDTOResponse> create(@Valid @RequestBody DiscountDTORequest discountDTORequest){
        try{
            return new ResponseEntity<>(discountService.create(discountDTORequest), HttpStatus.CREATED);
        } catch (DomainValidationException e){
            throw new GenericErrorException("Validation error when updating discount: "+ e.getMessage());
        } catch (Exception e) {
            throw new GenericErrorException("Error interno al actualizar descuento: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public DiscountDTOResponse getById(@PathVariable("id") Long id){
        return discountService.getById(id);
    }
    @GetMapping("/getByname/{discount}")
    public DiscountDTOResponse getByName(@PathVariable("name") String name) {
        return discountService.getByName(name);
    }

    @PutMapping("/{id}")
    public DiscountDTOResponse update(@PathVariable("id") Long discountId, @RequestBody DiscountDTORequest discountDTORequest) {
        return discountService.update(discountId, discountDTORequest);
    }
    @DeleteMapping("/{id}")
    public DiscountDTOResponse delete(@PathVariable("id") Long discountId){
        return discountService.delete(discountId);
    }

}
