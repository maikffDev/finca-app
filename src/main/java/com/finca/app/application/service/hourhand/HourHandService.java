package com.finca.app.application.service.hourhand;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;

import java.util.List;

public interface HourHandService {
    HourHandDTOResponse create(HourHandDTORequest request);
    List<HourHandDTOResponse> findAll();
    HourHandDTOResponse update(HourHandDTORequest dto);
    void delete(Long id);
}

