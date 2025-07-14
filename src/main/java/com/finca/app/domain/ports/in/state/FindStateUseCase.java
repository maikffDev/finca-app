package com.finca.app.domain.ports.in.state;
import com.finca.app.domain.models.State;
import java.util.List;
import java.util.Optional;

public interface FindStateUseCase {
    List<State> getAll();

    Optional<State> getById(Long id);

}
