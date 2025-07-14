package com.finca.app.application.usecases.state;

import com.finca.app.domain.models.State;
import com.finca.app.domain.ports.in.state.DeleteStateUseCase;
import com.finca.app.domain.ports.out.StateModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteStateUseCaseImpl implements DeleteStateUseCase {
    private StateModelPort stateModelPort;
    @Override
    public boolean delete(Long id) {
        return stateModelPort.deleteById(id);
    }

}
