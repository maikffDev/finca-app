package com.finca.app.application.dto.image;

import com.finca.app.domain.models.Finca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDTOResponse {

    private Long id;
    private String urlImage;

}
