package com.finca.app.application.services.finca.impl;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.finca.CreateFincaUseCase;
import com.finca.app.domain.ports.in.finca.DeleteFincaUseCase;
import com.finca.app.domain.ports.in.finca.FindFincaUseCase;
import com.finca.app.domain.ports.in.finca.UpdateFincaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaModelService implements CreateFincaUseCase, DeleteFincaUseCase, UpdateFincaUseCase, FindFincaUseCase {

    //TODO, OJO ACA , definan implementaciones por defecto porque sino FincaModelService se autoInyecta por ser el unico BEAN que implemente las 4 interfaces iniciales, generando depedencia CIRCULAR. impiendo que compile
    // TODAS las implementaciones tienen que llevar la anotacion "Service" sino no se reconoce como un BEAN y no es tomado como opcion para ser INYECTADO

    private final CreateFincaUseCase createFincaUseCase;
    private final DeleteFincaUseCase deleteFincaUseCase;
    private final UpdateFincaUseCase updateFincaUseCase;
    private final FindFincaUseCase findFincaUseCase;

    public FincaModelService(CreateFincaUseCase createFincaUseCase, DeleteFincaUseCase deleteFincaUseCase, UpdateFincaUseCase updateFincaUseCase, FindFincaUseCase findFincaUseCase){
        this.createFincaUseCase = createFincaUseCase;
        this.deleteFincaUseCase = deleteFincaUseCase;
        this.updateFincaUseCase = updateFincaUseCase;
        this.findFincaUseCase = findFincaUseCase;
    }

    @Override
    public Finca create(Finca finca){
        return createFincaUseCase.create(finca);
    }

    @Override
    public Boolean delete(Long id){
        return deleteFincaUseCase.delete(id);
    }

    @Override
    public Finca logicalDeletion(Finca finca){
        return deleteFincaUseCase.logicalDeletion(finca);
    }

    @Override
    public Optional<Finca> getById(Long id){
        return findFincaUseCase.getById(id);
    }

    @Override
    public Optional<Finca> getByName(String name){
        return findFincaUseCase.getByName(name);
    }

    @Override
    public List<Finca> getAll(){
        return findFincaUseCase.getAll();
    }

    @Override
    public Finca update(Finca finca){
        return updateFincaUseCase.update(finca);
    }
}
