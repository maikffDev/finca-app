package com.finca.app.application.usecases.finca;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.finca.GetAllAvailableFincasUseCase;
import com.finca.app.domain.ports.out.FincaModelPort;
import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.mappers.FincaDomainMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class GetAllAvailableFincasUseCaseImpl implements GetAllAvailableFincasUseCase {

    private final FincaModelPort fincaModelPort;
    private final FincaDomainMapper fincaDomainMapper;

    public GetAllAvailableFincasUseCaseImpl(FincaModelPort fincaModelPort, FincaDomainMapper fincaDomainMapper) {
        this.fincaModelPort = fincaModelPort;
        this.fincaDomainMapper = fincaDomainMapper;
    }

    @Override
    public List<Finca> getAllAvailableFincas() {
        List<FincaEntity> listFincaEntity = fincaModelPort.getAllAvailableFincas();
        return listFincaEntity.stream()
                .map(fincaDomainMapper::fromEntityToDomainManual)
                .collect(Collectors.toList());
    }
}
