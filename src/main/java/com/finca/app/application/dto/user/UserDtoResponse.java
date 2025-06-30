package com.finca.app.application.dto.user;

import lombok.Builder;

@Builder
public class UserDtoResponse {

    private Long userId;
    private String username;
    private String correo;
    private boolean activo;
    private boolean rollId;
}
