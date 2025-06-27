package com.finca.app.application.services.user.impl;

import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.application.dto.user.UserDtoResponse;
import com.finca.app.application.mappers.UserDTOMapper;
import com.finca.app.application.services.user.UserService;
import com.finca.app.domain.models.User;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserModelService userModelService;
    private final UserDTOMapper userDTOMapper;

    public UserServiceImpl(UserModelService userModelService, UserDTOMapper userDTOMapper){
        this.userModelService = userModelService;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    @Transactional
    public UserDtoResponse create(UserDtoRequest userDtoRequest) {
        String defaultPassword = "1234";
        userDtoRequest.setActivo(true);
        User user = userDTOMapper.toModel(userDtoRequest);
        user.setContrasena(defaultPassword);
        User newUser = userModelService.create(user);
        return userDTOMapper.toDto(newUser);
    }

    @Override
    public UserDtoResponse getById(Long userId) {
        User user = userModelService.getById(userId)
                .orElseThrow(() -> new RuntimeException("User with id '" + userId + "' not found."));
        return userDTOMapper.toDto(user);
    }

    @Override
    public UserDtoResponse getByUsername(String username) {
        User user = userModelService.getByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with username " + username + " not found."));
        return userDTOMapper.toDto(user);
    }

    @Override
    public UserDtoResponse update(Long userId, UserDtoRequest userDtoToUpdate) {
        User user = userModelService.getById(userId)
                .orElseThrow(() -> new RuntimeException("User with id '" + userId + "' not found."));

        User userToUpdate = userDTOMapper.toModel(userDtoToUpdate);

        user.setUsername(userToUpdate.getUsername());
        user.setActivo(userToUpdate.getActivo());
        user.setCorreo(userToUpdate.getCorreo());

        User updatedUser = userModelService.update(user);
        return userDTOMapper.toDto(updatedUser);
    }

    @Override
    public UserDtoResponse delete(Long userId) {
        User user = userModelService.getById(userId)
                .orElseThrow(() -> new RuntimeException("User with id '" + userId + "' not found."));
        boolean deleted = userModelService.delete(userId);
        if (deleted) {
            return userDTOMapper.toDto(user);
        }
        throw new RuntimeException("Could not delete user with id '" + userId + "'. Try again.");
    }

    @Override
    public UserDtoResponse logicalDeletion(Long userId) {
        User user = userModelService.getById(userId)
                .orElseThrow(() -> new RuntimeException("User with id '" + userId + "' not found."));
        user.setActivo(false);
        User deletedUser = userModelService.logicalDeletion(user);
        return userDTOMapper.toDto(deletedUser);
    }

    @Override
    public List<UserDtoResponse> getByRollId(Long rolId) {
        List<User> users = userModelService.getByRollId(rolId);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found with role id '" + rolId + "'.");
        }
        return users.stream()
                .map(userDTOMapper::toDto)
                .toList();
    }

}

