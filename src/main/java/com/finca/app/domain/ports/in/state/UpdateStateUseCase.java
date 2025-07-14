package com.finca.app.domain.ports.in.state;

import com.finca.app.domain.models.State;

public interface UpdateStateUseCase {
    State update(State state);
}
