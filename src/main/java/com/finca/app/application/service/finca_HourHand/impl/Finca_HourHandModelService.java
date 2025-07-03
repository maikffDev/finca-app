package com.finca.app.application.service.finca_HourHand.impl;

import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.ports.in.finca_HourHand.CreateFinca_HourHandUseCase;
import com.finca.app.domain.ports.in.finca_HourHand.DeleteFinca_HourHandUseCase;
import com.finca.app.domain.ports.in.finca_HourHand.FindFinca_HourHandUseCase;
import com.finca.app.domain.ports.in.finca_HourHand.UpdateFinca_HourHandUseCase;

import java.util.List;

public class Finca_HourHandModelService
        implements CreateFinca_HourHandUseCase,
        DeleteFinca_HourHandUseCase,
        UpdateFinca_HourHandUseCase,
        FindFinca_HourHandUseCase {

    private final CreateFinca_HourHandUseCase  createUseCase;
    private final DeleteFinca_HourHandUseCase  deleteUseCase;
    private final UpdateFinca_HourHandUseCase  updateUseCase;
    private final FindFinca_HourHandUseCase   findUseCase;

    public Finca_HourHandModelService(CreateFinca_HourHandUseCase createUseCase,
                                      DeleteFinca_HourHandUseCase deleteUseCase,
                                      UpdateFinca_HourHandUseCase updateUseCase,
                                      FindFinca_HourHandUseCase findUseCase) {
        this.createUseCase  = createUseCase;
        this.deleteUseCase  = deleteUseCase;
        this.updateUseCase  = updateUseCase;
        this.findUseCase    = findUseCase;
    }


    @Override
    public Finca_HourHand create(Finca_HourHand fh){ return createUseCase.create(fh); }
    @Override
    public Boolean delete(Long id){ return deleteUseCase.delete(id); }
    @Override
    public Finca_HourHand logicalDeletion(Finca_HourHand finca_HourHand){ return deleteUseCase.logicalDeletion(finca_HourHand);};
    @Override
    public Finca_HourHand update(Finca_HourHand fh){ return updateUseCase.update(fh); }


    @Override
    public List<Finca_HourHand> getAll(){ return findUseCase.getAll(); }
    @Override
    public List<Finca_HourHand> getById(Long id){ return findUseCase.getById(id); }
    @Override
    public List<Finca_HourHand> getByFincaId(Long id){ return findUseCase.getByFincaId(id); }
    @Override
    public List<Finca_HourHand> getByHourHandId(Long id){ return findUseCase.getByHourHandId(id); }
}
