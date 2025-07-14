package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.State;


import java.util.List;
import java.util.Optional;

public interface StateModelPort {
    State save(State state);
    Optional<State> findById(Long id);
    List<State> findAll();
    boolean deleteById(Long id);
    State logicalDeletion(State state);
    State update(State state);
}
