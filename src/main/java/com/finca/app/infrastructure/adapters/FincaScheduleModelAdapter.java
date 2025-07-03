package com.finca.app.infrastructure.adapters;

import com.finca.app.application.util.GenericErrorException;
import com.finca.app.domain.models.FincaSchedule;
import com.finca.app.domain.models.Schedule;
import com.finca.app.domain.ports.out.FincaScheduleModelPort;
import com.finca.app.infrastructure.entities.FincaScheduleEntity;
import com.finca.app.infrastructure.mappers.FincaScheduleDomainMapper;
import com.finca.app.infrastructure.mappers.ScheduleDomainMapper;
import com.finca.app.infrastructure.repositories.JpaFincaScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FincaScheduleModelAdapter implements FincaScheduleModelPort {

    private final JpaFincaScheduleRepository jpaFincaScheduleRepository;
    private final FincaScheduleDomainMapper fincaScheduleDomainMapper;
    private final ScheduleDomainMapper scheduleDomainMapper;

    public FincaScheduleModelAdapter(JpaFincaScheduleRepository jpaFincaScheduleRepository, FincaScheduleDomainMapper fincaScheduleDomainMapper, ScheduleDomainMapper scheduleDomainMapper) {
        this.jpaFincaScheduleRepository = jpaFincaScheduleRepository;
        this.fincaScheduleDomainMapper = fincaScheduleDomainMapper;
        this.scheduleDomainMapper = scheduleDomainMapper;
    }

    @Override
    public FincaSchedule save(FincaSchedule fincaSchedule) {
        try {
            FincaScheduleEntity fincaScheduleEntity = fincaScheduleDomainMapper.fromDomainModel(fincaSchedule);
            FincaScheduleEntity newFincaScheduleEntity = jpaFincaScheduleRepository.save(fincaScheduleEntity);
            return fincaScheduleDomainMapper.toDomainModel(newFincaScheduleEntity);
        } catch (GenericErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new GenericErrorException(e.getMessage());
        }
    }

    @Override
    public List<FincaSchedule> findAll() {
        List<FincaSchedule> fincaSchedules = jpaFincaScheduleRepository.findAll().stream().map((fincaScheduleEntity) -> fincaScheduleDomainMapper.toDomainModel(fincaScheduleEntity)).collect(Collectors.toList());
        return fincaSchedules;
    }

    @Override
    public Optional<FincaSchedule> findById(Long id){
        Optional<FincaSchedule> fincaSchedule = jpaFincaScheduleRepository.findById(id).map((fincaScheduleEntity) -> fincaScheduleDomainMapper.toDomainModel(fincaScheduleEntity));
        return fincaSchedule;
    }

    @Override
    public FincaSchedule update(FincaSchedule fincaSchedule){
        FincaScheduleEntity fincaScheduleEntity = fincaScheduleDomainMapper.fromDomainModel(fincaSchedule);
        FincaScheduleEntity updateFincaScheduleEntity = jpaFincaScheduleRepository.save(fincaScheduleEntity);
        return fincaScheduleDomainMapper.toDomainModel(updateFincaScheduleEntity);
    }

    @Override
    public Boolean delete(Long id){
        jpaFincaScheduleRepository.deleteById(id);
        return true;
    }

    @Override
    public FincaSchedule logicalDeletion(FincaSchedule fincaSchedule){
        FincaScheduleEntity fincaScheduleEntity = fincaScheduleDomainMapper.fromDomainModel(fincaSchedule);
        FincaScheduleEntity updatedFincaScheduleEntity = jpaFincaScheduleRepository.save(fincaScheduleEntity);
        return fincaScheduleDomainMapper.toDomainModel(updatedFincaScheduleEntity);
    }

    @Override
    public List<Schedule> getSchedulesByFincaId(Long fincaId){
        List<Schedule> schedules = jpaFincaScheduleRepository.findScheduleByFincaId(fincaId).stream().map((fincaScheduleEntity) -> scheduleDomainMapper.toDomainModel(fincaScheduleEntity)).collect(Collectors.toList());
        return schedules;
    }
}
