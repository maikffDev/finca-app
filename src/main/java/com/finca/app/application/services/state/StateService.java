package com.finca.app.application.services.state;

import com.finca.app.application.dto.state.StateDTORequest;
import com.finca.app.application.dto.state.StateDTOResponse;

import java.util.List;

public interface StateService {
    StateDTOResponse create(StateDTORequest stateDto);

    StateDTOResponse delete(Long id);

    List<StateDTOResponse> getAll();

    StateDTOResponse getById(Long id);

    StateDTOResponse update(Long id, StateDTORequest stateDTORequest);
}
