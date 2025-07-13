package com.finca.app.application.usecases.finca;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.finca.DeleteFincaUseCase;
import com.finca.app.domain.ports.out.FincaModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class DeleteFincaUseCaseImpl implements DeleteFincaUseCase {

    private final FincaModelPort fincaModelPort;

    public DeleteFincaUseCaseImpl(FincaModelPort fincaModelPort){
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public Boolean delete(Long id){
        return fincaModelPort.delete(id);
    }

    @Override
    public Finca logicalDeletion(Finca finca){
        return fincaModelPort.logicalDeletion(finca);
    }
}
