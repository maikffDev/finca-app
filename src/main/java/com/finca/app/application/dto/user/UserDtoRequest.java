package com.finca.app.application.dto.user;
import jakarta.validation.constraints.NotBlank;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class UserDtoRequest {

    @NotBlank(message = "Name cannot be empty")
    private String username;

    @NotBlank(message = "Email cannot be emmpty. Must have content")
    private String correo;

    private boolean Activo;

    @NotNull(message = "Role is required. An id must be provided")
    private boolean rollId;
}
