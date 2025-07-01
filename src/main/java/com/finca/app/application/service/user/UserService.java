package com.finca.app.application.service.user;

import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.application.dto.user.UserDtoResponse;

import java.util.List;

public interface UserService {

   UserDtoResponse create(UserDtoRequest userDto);

   UserDtoResponse getById(Long userId);

   UserDtoResponse getByUsername(String username);

   UserDtoResponse update(Long userId, UserDtoRequest userDtoToUpdate);

   UserDtoResponse delete(Long userId);

   UserDtoResponse logicalDeletion(Long userId);

   List<UserDtoResponse> getByRollId(Long userId);
}
