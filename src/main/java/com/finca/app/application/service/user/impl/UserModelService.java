package com.finca.app.application.service.user.impl;


import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.in.user.CreateUserUseCase;
import com.finca.app.domain.ports.in.user.DeleteUserUseCase;
import com.finca.app.domain.ports.in.user.FindUserUseCase;
import com.finca.app.domain.ports.in.user.UpdateUserUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserModelService implements CreateUserUseCase, DeleteUserUseCase, UpdateUserUseCase, FindUserUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private final FindUserUseCase findUserUseCase;


    public UserModelService(CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase, UpdateUserUseCase updateUserUseCase, FindUserUseCase findUserUseCase){

        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.findUserUseCase = findUserUseCase;
    }

    @Override
    @Transactional
    public User create(User user) {
        return createUserUseCase.create(user);
    }

    @Override
    public Boolean delete(Long userId) {
        return deleteUserUseCase.delete(userId);
    }

    @Override
    public User logicalDeletion(User user) {
        return deleteUserUseCase.logicalDeletion(user);
    }


    @Override
    public Page<User> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> getById(Long userId) {
        return findUserUseCase.getById(userId);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return findUserUseCase.getByUsername(username);
    }

    @Override
    public List<User> getByRollId(Long rollId) {
        return findUserUseCase.getByRollId(rollId);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return findUserUseCase.getByEmail(email);
    }

    @Override
    public User update(User user) {
        return updateUserUseCase.update(user);
    }
}
