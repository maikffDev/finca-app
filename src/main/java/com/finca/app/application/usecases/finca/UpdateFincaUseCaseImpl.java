package com.finca.app.application.usecases.finca;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.finca.UpdateFincaUseCase;
import com.finca.app.domain.ports.out.FincaModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UpdateFincaUseCaseImpl implements UpdateFincaUseCase {

    private final FincaModelPort fincaModelPort;

    public UpdateFincaUseCaseImpl(FincaModelPort fincaModelPort){
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public Finca update(Finca finca){
        return fincaModelPort.update(finca);
    }
}
