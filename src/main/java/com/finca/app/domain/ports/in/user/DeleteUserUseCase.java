package com.finca.app.domain.ports.in.user;
import com.finca.app.domain.models.User;

public interface DeleteUserUseCase {
    Boolean delete(Long id);

    User logicalDeletion(User user);
}
