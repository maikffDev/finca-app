package com.finca.app.application.services.user;

import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.application.dto.user.UserDtoResponse;
import com.finca.app.domain.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

   UserDtoResponse create(UserDtoRequest userDto);

   UserDtoResponse getById(Long userId);

   UserDtoResponse getByUsername(String username);

   UserDtoResponse update(Long userId, UserDtoRequest userDtoToUpdate);

   UserDtoResponse delete(Long userId);

   UserDtoResponse logicalDeletion(Long userId);

   List<UserDtoResponse> getByRollId(Long userId);
}
