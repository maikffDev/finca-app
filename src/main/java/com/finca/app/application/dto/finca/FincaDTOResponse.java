package com.finca.app.application.dto.finca;

import com.finca.app.domain.models.Finca;
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
    private String location;
    private double pricePerHour;
    private Boolean active;
    private List<String> images;

}
