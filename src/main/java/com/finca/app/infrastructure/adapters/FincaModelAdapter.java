package com.finca.app.infrastructure.adapters;


import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.out.FincaModelPort;
import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.entities.UserEntity;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import com.finca.app.infrastructure.mappers.FincaDomainMapper;
import com.finca.app.infrastructure.repositories.JpaFincaRepository;
import com.finca.app.infrastructure.repositories.JpaUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FincaModelAdapter implements FincaModelPort {

    private final JpaFincaRepository jpaFincaRepository;
    private final FincaDomainMapper fincaDomainMapper;
    private final JpaUserRepository jpaUserRepository;

    public FincaModelAdapter(JpaFincaRepository jpaFincaRepository, JpaUserRepository jpaUserRepository, FincaDomainMapper fincaDomainMapper){
        this.jpaFincaRepository = jpaFincaRepository;
        this.fincaDomainMapper = fincaDomainMapper;
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Finca save(Finca finca){
        try {
            if (jpaFincaRepository.existsByName(finca.getName())) {
                throw new GenericErrorException("Name is already in use");
            }
            if (jpaFincaRepository.existsByUbication(finca.getUbication())) {
                throw new GenericErrorException("Ubication is already in use");
            }

            Long userId = finca.getUser() != null ? finca.getUser().getUserId() : null;
            if (userId == null) {
                throw new GenericErrorException("User id must not be null");
            }

            UserEntity userEntity = jpaUserRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User with id '" + userId + "' not found."));

            FincaEntity fincaEntity = fincaDomainMapper.fromDomainModel(finca);
            fincaEntity.setUser(userEntity);

            FincaEntity newFincaEntity = jpaFincaRepository.save(fincaEntity);

            return fincaDomainMapper.toDomainModel(newFincaEntity);

        } catch (GenericErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new GenericErrorException(e.getMessage());
        }
    }

    @Override
    public List<Finca> findAll(){
        List<Finca> fincas = jpaFincaRepository.findAll().stream().map((fincaEntity) -> fincaDomainMapper.toDomainModel(fincaEntity)).collect(Collectors.toList());
        return fincas;
    }

    @Override
    public Optional<Finca> findById(Long id){
        return jpaFincaRepository.findById(id).map(fincaDomainMapper::toDomainModel);
    }

    @Override
    public Optional<Finca> findByUsername(String username){
        return jpaFincaRepository.findByUser_Username(username).map(fincaDomainMapper::toDomainModel);
    }

    @Override
    public Finca update(Finca finca){
        FincaEntity fincaEntity = fincaDomainMapper.fromDomainModel(finca);
        FincaEntity updatedFincaEntity = jpaFincaRepository.save(fincaEntity);
        return fincaDomainMapper.toDomainModel(updatedFincaEntity);
    }

    @Override
    public Boolean delete(Long id){
        jpaFincaRepository.deleteById(id);
        return true;
    }

    @Override
    public Finca logicalDeletion(Finca finca){
        FincaEntity fincaEntity = fincaDomainMapper.fromDomainModel(finca);
        FincaEntity updatedFincaEntity = jpaFincaRepository.save(fincaEntity);
        return fincaDomainMapper.toDomainModel(updatedFincaEntity);
    }
}
