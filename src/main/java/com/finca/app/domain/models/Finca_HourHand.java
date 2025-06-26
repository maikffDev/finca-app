package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Finca_HourHand {
    private Long id;
    private HourHand hourHand;
    private Finca finca;
}
