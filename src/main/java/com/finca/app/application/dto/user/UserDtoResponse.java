package com.finca.app.application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoResponse {

    private Long userId;
    private String username;
    private String correo;
    private boolean activo;
    private boolean rollId;
}
