package com.finca.app.application.dto.commentary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ComentaryDtoRequest {


    @NotBlank(message = "The content must not be blank")
    private String description;

    @NotNull(message = "An id of the user must be provided")
    private Long userId;

    @NotNull(message = "An id of the finca must be provided")
    private Long fincaId;
}
