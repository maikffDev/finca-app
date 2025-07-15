package com.finca.app.domain.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Finca {
    private Long id;
    private String name;
    private String ubication;
    private double pricePerHour;
    private List<HourHand> availableSchedules;
    private String description;
    private boolean active;
    private User user;
    private List<Image> images;

}
