package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDiscount {

    private Long id;
    private Discount discount;
    private User user;
    private int numberOfUses;
    private boolean active;

}
