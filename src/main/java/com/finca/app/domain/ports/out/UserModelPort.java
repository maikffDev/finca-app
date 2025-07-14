package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserModelPort {

    User save (User user);

    Boolean delete(Long id);

    User logicalDeletion(User user);

    User update(User user);

    Page<User> findAll(Pageable pageable);

    Optional<User> getById(Long userId);

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);

    List<User> getByRollId(Long rollId);
}
