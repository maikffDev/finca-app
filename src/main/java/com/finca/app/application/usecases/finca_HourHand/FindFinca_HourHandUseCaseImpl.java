package com.finca.app.application.usecases.finca_HourHand;


import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.ports.in.finca_HourHand.FindFinca_HourHandUseCase;
import com.finca.app.domain.ports.out.Finca_HourHandModelPort;

import java.util.List;

public class FindFinca_HourHandUseCaseImpl implements FindFinca_HourHandUseCase {

    private final Finca_HourHandModelPort findFinca_HourHandModelPort;

    public FindFinca_HourHandUseCaseImpl(Finca_HourHandModelPort findFinca_HourHandModelPort){ this.findFinca_HourHandModelPort = findFinca_HourHandModelPort;}

    @Override
    public List<Finca_HourHand> getAll(){return findFinca_HourHandModelPort.findAll();}

    @Override
    public List<Finca_HourHand> getById(Long id){return findFinca_HourHandModelPort.getById(id);}

    @Override
    public List<Finca_HourHand> getByFincaId(Long id){ return findFinca_HourHandModelPort.getByFincaId(id);};

    @Override
    public List<Finca_HourHand> getByHourHandId(Long id){ return findFinca_HourHandModelPort.getByHourHandId(id); };
}
