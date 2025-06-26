package com.finca.app.application.service.hourhand.impl;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.application.mappers.HourHandDTOMapper;
import com.finca.app.application.service.hourhand.HourHandService;
import com.finca.app.application.service.util.GenericErrorException;

import com.finca.app.application.util.GenericNoContentException;
import com.finca.app.domain.models.HourHand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HourHandServiceImpl implements HourHandService {

    private final HourHandModelService hourHand;
    private final HourHandDTOMapper hourHandDTOMapper;

    public HourHandServiceImpl(HourHandModelService hourHand, HourHandDTOMapper hourHandDTOMapper) {
        this.hourHand = hourHand;
        this.hourHandDTOMapper = hourHandDTOMapper;
    }

    public HourHandDTOResponse create(HourHandDTORequest request) {
        HourHand model = hourHandDTOMapper.toModel(request);
        HourHand created = hourHand.create(model);
        return hourHandDTOMapper.toDTO(created);
    }

    @Override
    public List<HourHandDTOResponse> findAll() {
        List<HourHand> list = hourHand.findAll();
        if (list.isEmpty()) {
            throw new GenericNoContentException("No HourHands found in the system.");
        }
        return hourHandDTOMapper.toDTOList(list);
    }

    public HourHandDTOResponse findById(Long id) {
        HourHand model = hourHand.findById(id)
                .orElseThrow(() -> new GenericNoContentException("HourHand with id '" + id + "' not found."));
        return hourHandDTOMapper.toDTO(model);
    }

    @Override
    public HourHandDTOResponse update(HourHandDTORequest dto) {
        HourHand existing = hourHand.findById(dto.getHourHand())
                .orElseThrow(() -> new GenericErrorException("CANNOT UPDATE. HourHand with id '" + dto.getHourHand() + "' not found."));

        existing.setDate(dto.getDate());
        existing.setStartTime(dto.getStartTime());
        existing.setEndTime(dto.getEndTime());

        HourHand updated = hourHand.update(existing);
        return hourHandDTOMapper.toDTO(updated);
    }


    @Override
    public void delete(Long id) {
        HourHand model = hourHand.findById(id)
                .orElseThrow(() -> new GenericErrorException("CANNOT DELETE. HourHand with id '" + id + "' not found."));
        boolean deleted = hourHand.deleteById(id);
        if (!deleted) {
            throw new GenericErrorException("CANNOT DELETE. Something went wrong.");
        }
    }

    public HourHandDTOResponse logicalDeletion(Long id) {
        HourHand model = hourHand.findById(id)
                .orElseThrow(() -> new GenericErrorException("CANNOT DISABLE. HourHand with id '" + id + "' not found."));
        model.setEndTime(null);
        HourHand disabled = hourHand.logicalDeletion(model);
        return hourHandDTOMapper.toDTO(disabled);
    }
}