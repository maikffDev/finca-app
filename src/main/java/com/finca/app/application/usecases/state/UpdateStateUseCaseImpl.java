package com.finca.app.application.usecases.state;

import com.finca.app.domain.models.State;
import com.finca.app.domain.ports.in.state.UpdateStateUseCase;
import com.finca.app.domain.ports.out.StateModelPort;

public class UpdateStateUseCaseImpl implements UpdateStateUseCase {
    private StateModelPort stateModelPort;
    @Override
    public State update(State state) {
        return stateModelPort.update(state);
    }
}
