package com.finca.app.application.service.finca_HourHand.impl;

import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTORequest;
import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTOResponse;
import com.finca.app.application.mappers.Finca_HourHandDTOMapper;
import com.finca.app.application.service.finca_HourHand.Finca_HourHandService;
import com.finca.app.application.service.util.GenericErrorException;
import com.finca.app.domain.models.Finca_HourHand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Finca_HourHandServiceImpl implements Finca_HourHandService {

    private final Finca_HourHandModelService fincaHourHandModelService;
    private final Finca_HourHandDTOMapper fincaHourHandDTOMapper;

    public Finca_HourHandServiceImpl(Finca_HourHandModelService fincaHourHandModelService,
                                     Finca_HourHandDTOMapper fincaHourHandDTOMapper) {
        this.fincaHourHandModelService = fincaHourHandModelService;
        this.fincaHourHandDTOMapper = fincaHourHandDTOMapper;
    }


    @Override
    public Finca_HourHandDTOResponse create(Finca_HourHandDTORequest dtoRequest) {
        Finca_HourHand model = fincaHourHandDTOMapper.toModel(dtoRequest);
        Finca_HourHand saved = fincaHourHandModelService.create(model);
        return fincaHourHandDTOMapper.toDto(saved);
    }

    @Override
    public Finca_HourHandDTOResponse update(Finca_HourHandDTORequest dtoRequest) {
        Finca_HourHand modelToUpdate = fincaHourHandDTOMapper.toModel(dtoRequest);
        Finca_HourHand updated = fincaHourHandModelService.update(modelToUpdate);
        return fincaHourHandDTOMapper.toDto(updated);
    }


    @Override
    public Finca_HourHandDTOResponse update(Long id, Finca_HourHandDTORequest dtoRequest) {
        Optional<Finca_HourHand> existingOpt = fincaHourHandModelService.getById(id).stream().findFirst();
        if (existingOpt.isEmpty()) {
            throw new GenericErrorException("CANNOT UPDATE. Finca_HourHand with id '" + id + "' not found.");
        }
        Finca_HourHand existing = existingOpt.get();
        Finca_HourHand updates = fincaHourHandDTOMapper.toModel(dtoRequest);

        existing.setFincaId(updates.getFincaId());
        existing.setHourHandId(updates.getHourHandId());
        existing.setHourHandStartTime(updates.getHourHandStartTime());
        existing.setHourHandEndTime(updates.getHourHandEndTime());

        Finca_HourHand saved = fincaHourHandModelService.update(existing);
        return fincaHourHandDTOMapper.toDto(saved);
    }

    @Override
    public Finca_HourHandDTOResponse delete(Long fincaHourHandId) {
        Optional<Finca_HourHand> entityOpt = fincaHourHandModelService.getById(fincaHourHandId).stream().findFirst();
        if (entityOpt.isEmpty()) {
            throw new GenericErrorException("CANNOT DELETE. Finca_HourHand with id '" + fincaHourHandId + "' not found.");
        }
        boolean deleted = fincaHourHandModelService.delete(fincaHourHandId);
        if (!deleted) {
            throw new GenericErrorException("CANNOT DELETE. Something went wrong during the process. Try again.");
        }
        return fincaHourHandDTOMapper.toDto(entityOpt.get());
    }


    @Override
    public Finca_HourHandDTOResponse logicalDeletion(Finca_HourHand fincaHourHand) {
        Finca_HourHand updated = fincaHourHandModelService.update(fincaHourHand);
        return fincaHourHandDTOMapper.toDto(updated);
    }

    /* ----------------------------- QUERIES ----------------------------- */

    @Override
    public Optional<Finca_HourHandDTOResponse> getById(Long id) {
        return fincaHourHandModelService.getById(id).stream()
                .findFirst()
                .map(fincaHourHandDTOMapper::toDto);
    }


    @Override
    public List<Finca_HourHandDTOResponse> getByFincaId(Long fincaId) {
        List<Finca_HourHand> list = fincaHourHandModelService.getByFincaId(fincaId);
        if (list.isEmpty()) {
            throw new GenericErrorException("No records found for fincaId " + fincaId);
        }
        return fincaHourHandDTOMapper.toDtoList(list);
    }


    @Override
    public List<Finca_HourHandDTOResponse> getByHourHandId(Long hourHandId) {
        List<Finca_HourHand> list = fincaHourHandModelService.getByHourHandId(hourHandId);
        if (list.isEmpty()) {
            throw new GenericErrorException("No Finca_HourHand records for HourHandId: " + hourHandId);
        }
        return fincaHourHandDTOMapper.toDtoList(list);
    }


    @Override
    public List<Finca_HourHandDTOResponse> getAll() {
        List<Finca_HourHand> list = fincaHourHandModelService.getAll();
        if (list.isEmpty()) {
            throw new GenericErrorException("No Finca_HourHand records were found in the database.");
        }
        return fincaHourHandDTOMapper.toDtoList(list);
    }
}
