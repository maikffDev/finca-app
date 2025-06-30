package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.out.FincaModelPort;
import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import com.finca.app.infrastructure.mappers.FincaDomainMapper;
import com.finca.app.infrastructure.repositories.JpaFincaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FincaModelAdapter implements FincaModelPort {

    private final JpaFincaRepository jpaFincaRepository;
    private final FincaDomainMapper fincaDomainMapper;

    public FincaModelAdapter(JpaFincaRepository jpaFincaRepository, FincaDomainMapper fincaDomainMapper){
        this.jpaFincaRepository = jpaFincaRepository;
        this.fincaDomainMapper = fincaDomainMapper;
    }

    @Override
    public Finca save(Finca finca){
        try{
            if (jpaFincaRepository.existsByName(finca.getName())){
                throw new GenericErrorException("Name is already in use");
            }
            if (jpaFincaRepository.existByUbication(finca.getUbication())){
                throw new GenericErrorException("Ubication is already in use");
            }
            FincaEntity fincaEntity = fincaDomainMapper.fromDomainModel(finca);
            FincaEntity newFincaEntity = jpaFincaRepository.save(fincaEntity);
            return fincaDomainMapper.toDomainModel(newFincaEntity);
        }catch (GenericErrorException e){
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
        return jpaFincaRepository.findByUsername(username).map(fincaDomainMapper::toDomainModel);
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
