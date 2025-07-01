package com.finca.app.application.usecases.finca;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.FindFincaUseCase;
import com.finca.app.domain.ports.out.FincaModelPort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class FindFincaUseCaseImpl implements FindFincaUseCase {

    private final FincaModelPort fincaModelPort;

    public FindFincaUseCaseImpl(FincaModelPort fincaModelPort){
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public List<Finca> getAll(){
        return fincaModelPort.findAll();
    }

    @Override
    public Optional<Finca> getById(Long id){
        return fincaModelPort.findById(id);
    }

    @Override
    public Optional<Finca> getByUsername(String username){
        return fincaModelPort.findByUsername(username);
    }
}
