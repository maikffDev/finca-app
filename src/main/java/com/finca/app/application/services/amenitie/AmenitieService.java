package com.finca.app.application.service.amenitie;

import com.finca.app.application.dto.amenitie.AmenitieDTORequest;
import com.finca.app.application.dto.amenitie.AmenitieDTOResponse;

import java.util.List;
import java.util.Optional;

public interface AmenitieService {
    AmenitieDTOResponse create(AmenitieDTORequest request);
    List<AmenitieDTOResponse> getAll();
    Optional<AmenitieDTOResponse> getById(Long id);
    boolean delete(Long id);
}