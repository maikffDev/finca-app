package com.finca.app.application.service.user;

import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.application.dto.user.UserDtoResponse;
import com.finca.app.domain.models.User;

import java.util.List;

public interface UserService {

   UserDtoResponse create(UserDtoRequest userDto);

   UserDtoResponse getById(Long userId);

   UserDtoResponse getByUsername(String username);

   UserDtoResponse update(Long userId, UserDtoRequest userDtoToUpdate);

   UserDtoResponse delete(Long userId);

   UserDtoResponse logicalDeletion(Long userId);

    User getEntityById(Long userId);

   List<UserDtoResponse> getByRollId(Long userId);
}
