package com.finca.app.application.service.hourhand;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;

import java.util.List;

public interface HourHandService {
    HourHandDTOResponse create(HourHandDTORequest dto);
    List<HourHandDTOResponse> findAll();
    void delete(Long id);
}
