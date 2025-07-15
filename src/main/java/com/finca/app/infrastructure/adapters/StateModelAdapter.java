package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.State;
import com.finca.app.domain.ports.out.StateModelPort;
import com.finca.app.infrastructure.entities.StateEntity;
import com.finca.app.infrastructure.mappers.StateDomainMapper;
import com.finca.app.infrastructure.repositories.JpaStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StateModelAdapter implements StateModelPort {
    private final JpaStateRepository stateRepository;
    private final StateDomainMapper stateDomainMapper;

    public StateModelAdapter(JpaStateRepository stateRepository, StateDomainMapper stateDomainMapper) {
        this.stateRepository = stateRepository;
        this.stateDomainMapper = stateDomainMapper;
    }

    @Override
    public State save(State state) {
        StateEntity entity = stateDomainMapper.toEntity(state);

        StateEntity savedEntity = stateRepository.save(entity);

        return stateDomainMapper.toModel(savedEntity);
    }

    @Override
    public Optional<State> findById(Long id) {
        return stateRepository.findById(id).map(stateDomainMapper::toModel);
    }

    @Override
    public List<State> findAll() {
        return stateRepository.findAll().stream().map(stateDomainMapper::toModel).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<StateEntity> foundEntity = stateRepository.findById(id);
        if (foundEntity.isEmpty()) {
            return false;
        }
        stateRepository.deleteById(id);
        return true;
    }


    @Override
    public State update(State state) {

        StateEntity entity = stateDomainMapper.toEntity(state);

        StateEntity savedEntity = stateRepository.save(entity);

        return stateDomainMapper.toModel(savedEntity);
    }
}
