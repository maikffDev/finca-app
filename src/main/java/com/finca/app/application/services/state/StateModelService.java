package com.finca.app.application.services.state;

import com.finca.app.domain.models.State;
import com.finca.app.domain.ports.in.state.CreateStateUseCase;
import com.finca.app.domain.ports.in.state.DeleteStateUseCase;
import com.finca.app.domain.ports.in.state.FindStateUseCase;
import com.finca.app.domain.ports.in.state.UpdateStateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateModelService implements CreateStateUseCase, DeleteStateUseCase, UpdateStateUseCase, FindStateUseCase {

    private final CreateStateUseCase createStateUseCase;
    private final DeleteStateUseCase deleteStateUseCase;
    private final UpdateStateUseCase updateStateUseCase;
    private final FindStateUseCase findStateUseCase;

    public StateModelService(CreateStateUseCase createStateUseCase, DeleteStateUseCase deleteStateUseCase, UpdateStateUseCase updateStateUseCase, FindStateUseCase findStateUseCase) {
        this.createStateUseCase = createStateUseCase;
        this.deleteStateUseCase = deleteStateUseCase;
        this.updateStateUseCase = updateStateUseCase;
        this.findStateUseCase = findStateUseCase;
    }

    @Override
    public State create(State state) {
        return createStateUseCase.create(state);
    }

    @Override
    public boolean delete(Long id) {
        return deleteStateUseCase.delete(id);
    }


    @Override
    public List<State> getAll() {
        return findStateUseCase.getAll();
    }

    @Override
    public Optional<State> getById(Long id) {
        return findStateUseCase.getById(id);
    }

    @Override
    public State update(State state) {
        return updateStateUseCase.update(state);
    }
}
