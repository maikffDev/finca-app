package com.finca.app.domain.ports.in.user;

import com.finca.app.domain.models.User;

public interface UpdateUserUseCase {
    User update (User user);
}
