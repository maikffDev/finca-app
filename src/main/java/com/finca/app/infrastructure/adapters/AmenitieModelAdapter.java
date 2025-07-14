package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Amenitie;
import com.finca.app.domain.ports.out.AmenitieModelPort;
import com.finca.app.infrastructure.entities.AmenitieEntity;
import com.finca.app.infrastructure.mappers.AmenitieDomainMapper;
import com.finca.app.infrastructure.repositories.JpaAmenitieRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AmenitieModelAdapter implements AmenitieModelPort {

    private final JpaAmenitieRepository jpaAmenitieRepository;
    private final AmenitieDomainMapper amenitieDomainMapper;

    public AmenitieModelAdapter(JpaAmenitieRepository jpaAmenitieRepository, AmenitieDomainMapper amenitieDomainMapper) {
        this.jpaAmenitieRepository = jpaAmenitieRepository;
        this.amenitieDomainMapper = amenitieDomainMapper;
    }

    @Override
    public Amenitie save(Amenitie amenitie) {
        AmenitieEntity amenitieEntity = amenitieDomainMapper.fromDomainModel(amenitie);
        AmenitieEntity savedEntity = jpaAmenitieRepository.save(amenitieEntity);
        return amenitieDomainMapper.toDomainModel(savedEntity);
    }

    @Override
    public Optional<Amenitie> findById(Long id) {
        return jpaAmenitieRepository.findById(id).map(amenitieDomainMapper::toDomainModel);
    }

    @Override
    public List<Amenitie> findAll() {
        return jpaAmenitieRepository.findAll().stream()
                .map(amenitieDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaAmenitieRepository.existsById(id)) {
            jpaAmenitieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return jpaAmenitieRepository.existsById(id);
    }
}