package com.finca.app.application.dto.finca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaDTOResponse {
    private Long id;
    private Long userId;
    private String name;
    private String location;
    private String description;
    private String pricePerHour;
    private Boolean active;
}
