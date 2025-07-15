    package com.finca.app.application.usecases.state;

    import com.finca.app.domain.models.State;
    import com.finca.app.domain.ports.in.state.CreateStateUseCase;
    import com.finca.app.domain.ports.out.StateModelPort;
    import com.finca.app.domain.ports.out.UserModelPort;
    import org.springframework.stereotype.Service;

    @Service
    public class CreateStateUseCaseImpl implements CreateStateUseCase {
        private final StateModelPort stateModelPort;

        public CreateStateUseCaseImpl(StateModelPort stateModelPort) {
            this.stateModelPort = stateModelPort;
        }

        @Override
        public State create(State state) {
            return stateModelPort.save(state);
        }
    }
