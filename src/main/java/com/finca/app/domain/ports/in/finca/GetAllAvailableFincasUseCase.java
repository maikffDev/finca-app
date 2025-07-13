package com.finca.app.domain.ports.in.finca;

import com.finca.app.domain.models.Finca;

import java.util.List;

public interface GetAllAvailableFincasUseCase {
    public List<Finca> getAllAvailableFincas();
}
