package com.finca.app.domain.ports.in.usuario;

import com.finca.app.domain.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface FindUserUseCase {

        Page<User> getAll(Pageable pageable);

        Optional<User> getById(Long userId);

        Optional<User> getByUsername(String username);

        List<User> getByRollId(Long rollId);

        Optional<User> getByEmail(String email);

}
