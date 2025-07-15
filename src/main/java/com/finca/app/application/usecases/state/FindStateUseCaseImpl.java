package com.finca.app.application.usecases.state;

import com.finca.app.domain.models.State;
import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.in.state.FindStateUseCase;
import com.finca.app.domain.ports.out.StateModelPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindStateUseCaseImpl implements FindStateUseCase {
    private StateModelPort stateModelPort;
    @Override
    public List<State> getAll() {
        return stateModelPort.findAll();
    }
    @Override
    public Optional<State> getById(Long id) {
        return stateModelPort.findById(id);
    }

}
