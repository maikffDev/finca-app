package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    private Long id;
    private String name;
    private int discountPercentage;
    private Set<UserDiscount> usersDicounts;

}
