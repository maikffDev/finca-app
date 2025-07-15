package com.finca.app.application.dto.finca;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FincaDTOResponse {
    private Long id;
    private String name;
    private String ubication;
    private double pricePerHour;
    private Boolean active;
    private List<String> images;

}
