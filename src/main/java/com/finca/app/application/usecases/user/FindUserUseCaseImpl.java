package com.finca.app.application.usecases.user;

import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.in.usuario.FindUserUseCase;
import com.finca.app.domain.ports.out.UserModelPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindUserUseCaseImpl implements FindUserUseCase {

    private final UserModelPort userModelPort;

    public FindUserUseCaseImpl(UserModelPort userModelPort) {
        this.userModelPort = userModelPort;
    }


    @Override
    public Page<User> getAll(Pageable pageable) {
        return userModelPort.findAll(pageable);
    }

    @Override
    public Optional<User> getById(Long userId) {
        return userModelPort.getById(userId);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userModelPort.getByUsername(username);
    }

    @Override
    public List<User> getByRollId(Long rollId) {
        return userModelPort.getByRollId(rollId);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userModelPort.getByEmail(email);
    }
}
