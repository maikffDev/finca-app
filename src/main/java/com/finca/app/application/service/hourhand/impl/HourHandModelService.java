package com.finca.app.application.service.hourhand.impl;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.domain.models.HourHand;

import java.util.List;

public class HourHandModelService {
    HourHandDTOResponse create(HourHandDTORequest dto);
    List<HourHandDTOResponse> findAll();
    HourHandDTOResponse update(HourHand dto);
    void delete(Long id);

    protected void deleteById(Long id) {
    }
}
