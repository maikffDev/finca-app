package com.finca.app.application.usecases.user;

import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.in.usuario.CreateUserUseCase;
import com.finca.app.domain.ports.out.UserModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserModelPort userModelPort;

    public CreateUserUseCaseImpl(UserModelPort userModelPort) {
        this.userModelPort = userModelPort;
    }

    @Override
    public User create(User user) {
        return userModelPort.save(user);
    }
}
