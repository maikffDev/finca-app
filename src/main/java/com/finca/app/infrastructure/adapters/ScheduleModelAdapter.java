package com.finca.app.infrastructure.adapters;



import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.out.ScheduleModelPort;

import com.finca.app.infrastructure.entities.ScheduleEntity;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import com.finca.app.infrastructure.mappers.ScheduleDomainMapper;
import com.finca.app.infrastructure.repositories.JpaScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleModelAdapter implements ScheduleModelPort {

    private final JpaScheduleRepository jpaScheduleRepository;
    private final ScheduleDomainMapper scheduleDomainMapper;

    public ScheduleModelAdapter(JpaScheduleRepository jpaScheduleRepository, ScheduleDomainMapper scheduleDomainMapper) {
        this.jpaScheduleRepository = jpaScheduleRepository;
        this.scheduleDomainMapper = scheduleDomainMapper;
    }

    @Override
    public Schedule save(Schedule schedule) {
        try {
            ScheduleEntity scheduleEntity = scheduleDomainMapper.fromDomainModel(schedule);
            ScheduleEntity newScheduleEntity = jpaScheduleRepository.save(scheduleEntity);
            return scheduleDomainMapper.toDomainModel(newScheduleEntity);
        } catch (Exception e) {
            throw new GenericErrorException("Failed to save Schedule: " + e.getMessage());
        }
    }

    @Override
    public List<Schedule> getAll() {
        return jpaScheduleRepository.findAll()
                .stream()
                .map(scheduleDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return jpaScheduleRepository.findById(id)
                .map(scheduleDomainMapper::toDomainModel);
    }

    @Override
    public Schedule update(Schedule schedule) {
        try {
            ScheduleEntity entity = scheduleDomainMapper.fromDomainModel(schedule);
            ScheduleEntity updated = jpaScheduleRepository.save(entity);
            return scheduleDomainMapper.toDomainModel(updated);
        } catch (Exception e) {
            throw new GenericErrorException("Failed to update Schedule: " + e.getMessage());
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            jpaScheduleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GenericErrorException("Failed to delete Schedule: " + e.getMessage());
        }
    }

    @Override
    public Schedule logicalDeletion(Schedule schedule) {
        try {
            ScheduleEntity entity = scheduleDomainMapper.fromDomainModel(schedule);
            ScheduleEntity updated = jpaScheduleRepository.save(entity);
            return scheduleDomainMapper.toDomainModel(updated);
        } catch (Exception e) {
            throw new GenericErrorException("Failed in logical deletion: " + e.getMessage());
        }
    }
}
