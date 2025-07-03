package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Finca {
    private Long id;
    private String name;
    private String ubication;
    private Double pricePerHour;
    private List<Schedule> availableSchedules;
    private String description;
    private Boolean active;
    private User user;
}
