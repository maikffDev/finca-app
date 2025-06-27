package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Finca {

    private Long id;
    private String name;
    private String location;
    private double pricePerHour;
    private User user;
    private String description;
    private boolean active;
    private List<HourHand> schedule = new ArrayList<>();

}
