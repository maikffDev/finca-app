package com.finca.app.infrastructure.adapters;

import com.finca.app.application.service.util.GenericErrorException;
import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.ports.out.Finca_HourHandModelPort;
import com.finca.app.infrastructure.entities.Finca_HourHandEntity;
import com.finca.app.infrastructure.mappers.Finca_HourHandDomainMapper;
import com.finca.app.infrastructure.repositories.JpaFinca_HourHandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Finca_HourHandModelAdapter implements Finca_HourHandModelPort {

    private final JpaFinca_HourHandRepository jpaFincaHourHandRepository;
    private final Finca_HourHandDomainMapper fincaHourHandDomainMapper;

    public Finca_HourHandModelAdapter(JpaFinca_HourHandRepository jpaFincaHourHandRepository,
                                      Finca_HourHandDomainMapper fincaHourHandDomainMapper) {
        this.jpaFincaHourHandRepository = jpaFincaHourHandRepository;
        this.fincaHourHandDomainMapper = fincaHourHandDomainMapper;
    }

    @Override
    public Finca_HourHand save(Finca_HourHand fincaHourHand) {
        try {
            Finca_HourHandEntity entity = fincaHourHandDomainMapper.fromDomainModel(fincaHourHand);
            Finca_HourHandEntity saved = jpaFincaHourHandRepository.save(entity);
            return fincaHourHandDomainMapper.toDomainModel(saved);
        } catch (Exception e) {
            throw new GenericErrorException("Failed to save Finca_HourHand: " + e.getMessage());
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            jpaFincaHourHandRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GenericErrorException("Failed to delete Finca_HourHand: " + e.getMessage());
        }
    }

    @Override
    public List<Finca_HourHand> findAll() {
        return jpaFincaHourHandRepository.findAll().stream()
                .map(fincaHourHandDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Finca_HourHand> getByFincaId(Long fincaId) {
        return jpaFincaHourHandRepository.findByFincaId(fincaId).stream()
                .map(fincaHourHandDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Finca_HourHand> getByHourHandId(Long hourHandId) {
        return jpaFincaHourHandRepository.findByHourHandId(hourHandId).stream()
                .map(fincaHourHandDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Finca_HourHand update(Finca_HourHand fincaHourHand) {
        return save(fincaHourHand);
    }

    @Override
    public List<Finca_HourHand> getById(Long id) {
        return jpaFincaHourHandRepository.findById(id)
                .map(fincaHourHandDomainMapper::toDomainModel)
                .stream()
                .toList();
    }
}
