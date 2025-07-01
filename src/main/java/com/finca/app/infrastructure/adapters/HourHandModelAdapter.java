package com.finca.app.infrastructure.adapters;



import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.ports.out.HourHandModelPort;

import com.finca.app.infrastructure.entities.HourHandEntity;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import com.finca.app.infrastructure.mappers.HourHandDomainMapper;
import com.finca.app.infrastructure.repositories.JpaHourHandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HourHandModelAdapter implements HourHandModelPort {

    private final JpaHourHandRepository jpaHourHandRepository;
    private final HourHandDomainMapper hourHandDomainMapper;

    public HourHandModelAdapter(JpaHourHandRepository jpaHourHandRepository, HourHandDomainMapper hourHandDomainMapper) {
        this.jpaHourHandRepository = jpaHourHandRepository;
        this.hourHandDomainMapper = hourHandDomainMapper;
    }

    @Override
    public HourHand save(HourHand hourHand) {
        try {
            HourHandEntity entity = hourHandDomainMapper.fromDomainModel(hourHand);
            HourHandEntity saved = jpaHourHandRepository.save(entity);
            return hourHandDomainMapper.toDomainModel(saved);
        } catch (Exception e) {
            throw new GenericErrorException("Failed to save HourHand: " + e.getMessage());
        }
    }

    @Override
    public List<HourHand> findAll() {
        return jpaHourHandRepository.findAll()
                .stream()
                .map(hourHandDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HourHand> findById(Long id) {
        return jpaHourHandRepository.findById(id)
                .map(hourHandDomainMapper::toDomainModel);
    }

    @Override
    public HourHand update(HourHand hourHand) {
        try {
            HourHandEntity entity = hourHandDomainMapper.fromDomainModel(hourHand);
            HourHandEntity updated = jpaHourHandRepository.save(entity);
            return hourHandDomainMapper.toDomainModel(updated);
        } catch (Exception e) {
            throw new GenericErrorException("Failed to update HourHand: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            jpaHourHandRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GenericErrorException("Failed to delete HourHand: " + e.getMessage());
        }
    }

    @Override
    public HourHand logicalDeletion(HourHand hourHand) {
        try {
            HourHandEntity entity = hourHandDomainMapper.fromDomainModel(hourHand);
            HourHandEntity updated = jpaHourHandRepository.save(entity);
            return hourHandDomainMapper.toDomainModel(updated);
        } catch (Exception e) {
            throw new GenericErrorException("Failed in logical deletion: " + e.getMessage());
        }
    }
}
