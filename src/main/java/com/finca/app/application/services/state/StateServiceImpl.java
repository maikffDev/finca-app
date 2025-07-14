package com.finca.app.application.services.state;

import com.finca.app.application.dto.state.StateDTORequest;
import com.finca.app.application.dto.state.StateDTOResponse;
import com.finca.app.application.mappers.StateDTOMapper;
import com.finca.app.domain.models.State;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import org.springframework.stereotype.Service;
import com.finca.app.application.services.state.impl.StateModelService;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private final StateModelService stateModelService;
    private final StateDTOMapper stateDTOMapper;

    public StateServiceImpl(StateModelService stateModelService, StateDTOMapper stateDTOMapper) {
        this.stateModelService = stateModelService;
        this.stateDTOMapper = stateDTOMapper;
    }

    @Override
    public StateDTOResponse create(StateDTORequest stateDTO) {
        State state = stateDTOMapper.toModel(stateDTO);
        State newState = stateModelService.create(state);
        return stateDTOMapper.toDto(newState);
    }

    @Override
    public List<StateDTOResponse> getAll() {
        List<State> states = stateModelService.getAll();
        if (states.isEmpty()) {
            throw new GenericErrorException("No states found in the database.");
        }
        return stateDTOMapper.toDtoList(states);
    }

    @Override
    public StateDTOResponse getById(Long id) {
        State state = stateModelService.getById(id)
                .orElseThrow(() -> new GenericErrorException("State with id '" + id + "' not found."));
        return stateDTOMapper.toDto(state);
    }

    @Override
    public StateDTOResponse update(Long id, StateDTORequest stateDTO) {
        State existingState = stateModelService.getById(id)
                .orElseThrow(() -> new GenericErrorException("CANNOT UPDATE. State with id '" + id + "' not found."));
        State stateUpdate = stateDTOMapper.toModel(stateDTO);
        existingState.setDescription(stateUpdate.getDescription());
        State updatedState = stateModelService.update(existingState);
        return stateDTOMapper.toDto(updatedState);
    }

    @Override
    public StateDTOResponse delete(Long id) {
        State state = stateModelService.getById(id)
                .orElseThrow(() -> new GenericErrorException("CANNOT DELETE. State with id '" + id + "' not found."));
        Boolean isDeleted = stateModelService.delete(id);
        if (isDeleted) {
            return stateDTOMapper.toDto(state);
        }
        throw new GenericErrorException("CANNOT DELETE. Something went wrong during the process. Try again.");
    }
}
