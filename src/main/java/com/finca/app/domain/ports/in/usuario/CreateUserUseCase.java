package com.finca.app.domain.ports.in.usuario;

import com.finca.app.domain.models.User;

public interface CreateUserUseCase {
    User create(User user);
}
