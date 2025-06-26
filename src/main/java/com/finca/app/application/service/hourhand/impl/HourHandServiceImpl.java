package com.finca.app.application.service.hourhand.impl;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.application.mappers.HourHandDTOMapper;
import com.finca.app.domain.models.HourHand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class HourHandServiceImpl extends HourHandModelService {
    private final HourHandModelService hourHand;
    private final HourHandDTOMapper hourHandDTOMapper;

    public HourHandServiceImpl(HourHandModelService hourHand, HourHandDTOMapper hourHandDTOMapper) {
        this.hourHand = hourHand;
        this.hourHandDTOMapper = hourHandDTOMapper;
    }


    @Override
    public List<HourHandDTOResponse> findAll() {
        return hourHand.findAll().stream().map(HourHandDTOMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HourHandDTOResponse update(HourHand dto) {
    }

    @Override
    public void delete(Long id) {
        hourHand.deleteById(id);
    }
}

