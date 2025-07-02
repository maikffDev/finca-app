package com.finca.app.application.service.finca.impl;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.mappers.FincaDTOMapper;
import com.finca.app.application.service.finca.FincaService;
import com.finca.app.domain.models.Finca;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import com.finca.app.infrastructure.exceptions.GenericNoContentException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FincaServiceImpl implements FincaService {

    private final FincaModelService fincaModelService;
    private final FincaDTOMapper fincaDTOMapper;

    public FincaServiceImpl(FincaModelService fincaModelService, FincaDTOMapper fincaDTOMapper){
        this.fincaModelService = fincaModelService;
        this.fincaDTOMapper = fincaDTOMapper;
    }

    @Override
    public FincaDTOResponse create(FincaDTORequest fincaDto){
        Finca finca = fincaDTOMapper.toModel(fincaDto);
        Finca newFinca = fincaModelService.create(finca);
        return fincaDTOMapper.toDto(newFinca);
    }

    @Override
    public List<FincaDTOResponse> getAll(){
        List<Finca> finca = fincaModelService.getAll();
        if (finca.isEmpty()){
            throw new GenericNoContentException("No finca were found in the database.");
        }
        return fincaDTOMapper.toDtoList(finca);
    }

    @Override
    public FincaDTOResponse getById(Long id){
        Finca finca = fincaModelService.getById(id).orElseThrow(() -> new GenericNoContentException("Finca with id '" + id + "' not found."));
        return fincaDTOMapper.toDto(finca);
    }

    @Override
    public FincaDTOResponse getByUser(String username){
        Finca finca = fincaModelService.getByUsername(username).orElseThrow(() -> new GenericNoContentException("Finca with username '" + username + "' not found."));
        return fincaDTOMapper.toDto(finca);
    }

    @Override
    public FincaDTOResponse update(Long fincaId, FincaDTORequest fincaDto){
        Finca finca = fincaModelService.getById(fincaId).orElseThrow(() -> new GenericErrorException("CANNOT UPDATE. Finca with id '" + fincaId + "' not found."));
        Finca fincaToUpdate = fincaDTOMapper.toModel(fincaDto);
        finca.setName(fincaToUpdate.getName());
        finca.setUbication(fincaToUpdate.getUbication());
        finca.setPricePerHour(fincaToUpdate.getPricePerHour());
        finca.setDescription(fincaToUpdate.getDescription());
        finca.setActive(fincaToUpdate.isActive());
        Finca updatedFinca = fincaModelService.update(finca);
        return fincaDTOMapper.toDto(updatedFinca);
    }

    @Override
    public FincaDTOResponse delete(Long id){
        Finca finca = fincaModelService.getById(id).orElseThrow(() -> new GenericErrorException("CANNOT DELETE. Finca with id '" + id + "' not found."));
        Boolean isDelete = fincaModelService.delete(id);
        if (isDelete == true){
            return fincaDTOMapper.toDto(finca);
        }
        throw new GenericErrorException("CANNOT DELETE. Something went wrong during the process. Try again.");
    }

    @Override
    public FincaDTOResponse logicalDeletion(Long id){
        Finca finca = fincaModelService.getById(id).orElseThrow(() -> new GenericErrorException("CANNOT DISABLE. Finca with id '" + id + "' not found."));
        finca.setActive(false);
        Finca disableFinca = fincaModelService.logicalDeletion(finca);
        return fincaDTOMapper.toDto(disableFinca);
    }
}
