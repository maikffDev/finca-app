package com.finca.app.application.dto.commentary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


public class ComentaryDtoRequest {


    @NotNull(message = "An id of the commentary must be provided")
    private Long commentaryId;

    @NotBlank(message = "The content must not be blank")
    private String description;

    @NotNull(message = "An id of the user must be provided")
    private Long userId;

    @NotNull(message = "An id of the finca must be provided")
    private Long fincaId;
}
