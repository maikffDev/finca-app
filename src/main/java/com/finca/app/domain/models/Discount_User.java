package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Discount_User {
    private Long id;
    private Long discountID;
    private Long userID;
    private Long cantUse;
    private Boolean status;
}
