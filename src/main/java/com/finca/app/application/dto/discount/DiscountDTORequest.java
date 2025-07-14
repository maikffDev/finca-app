package com.finca.app.application.dto.discount;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTORequest {
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    @NotBlank(message = "Discount Percentage cannot be empty.")
    private Double discountPercentage;
}

