package com.finca.app.application.usecases.user;

import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.in.usuario.DeleteUserUseCase;
import com.finca.app.domain.ports.out.UserModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserModelPort userModelPort;

    public DeleteUserUseCaseImpl(UserModelPort userModelPort) {
        this.userModelPort = userModelPort;
    }

    @Override
    public Boolean delete(Long id) {
        return userModelPort.delete(id);
    }

    @Override
    public User logicalDeletion(User user) {
       return userModelPort.logicalDeletion(user);
    }
}
