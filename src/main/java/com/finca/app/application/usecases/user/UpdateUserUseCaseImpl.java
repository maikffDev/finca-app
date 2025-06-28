package com.finca.app.application.usecases.user;

import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.in.usuario.UpdateUserUseCase;
import com.finca.app.domain.ports.out.UserModelPort;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserModelPort userModelPort;

    public UpdateUserUseCaseImpl(UserModelPort userModelPort) {
        this.userModelPort = userModelPort;
    }

    @Override
    public User update(User user) {
        return userModelPort.update(user);
    }
}
