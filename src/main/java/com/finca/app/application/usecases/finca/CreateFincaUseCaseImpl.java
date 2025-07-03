package com.finca.app.application.usecases.finca;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.finca.CreateFincaUseCase;
import com.finca.app.domain.ports.out.FincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateFincaUseCaseImpl implements CreateFincaUseCase {

    private final FincaModelPort fincaModelPort;

    public CreateFincaUseCaseImpl(FincaModelPort fincaModelPort){
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public Finca create(Finca finca){
        return fincaModelPort.save(finca);
    }
}
