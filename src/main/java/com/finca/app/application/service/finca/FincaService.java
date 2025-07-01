package com.finca.app.application.service.finca;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;

import java.util.List;

public interface FincaService {

    FincaDTOResponse create(FincaDTORequest fincaDto);

    List<FincaDTOResponse> getAll();

    FincaDTOResponse getById(Long id);

    FincaDTOResponse getByUser(String user);

    FincaDTOResponse update(Long fincaId, FincaDTORequest fincaDtoToUpdate);

    FincaDTOResponse delete(Long id);

    FincaDTOResponse logicalDeletion(Long id);
}
