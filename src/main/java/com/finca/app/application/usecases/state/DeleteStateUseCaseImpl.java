package com.finca.app.application.usecases.state;

import com.finca.app.domain.models.State;
import com.finca.app.domain.ports.in.state.DeleteStateUseCase;
import com.finca.app.domain.ports.out.StateModelPort;

public class DeleteStateUseCaseImpl implements DeleteStateUseCase {
    private StateModelPort stateModelPort;
    @Override
    public boolean delete(Long id) {
        return stateModelPort.deleteById(id);
    }

    @Override
    public State logicalDeletion(State state) {
        return stateModelPort.logicalDeletion(state);
    }
}
