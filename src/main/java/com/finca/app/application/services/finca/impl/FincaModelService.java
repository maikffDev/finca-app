package com.finca.app.application.services.finca.impl;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.ports.in.finca.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaModelService implements CreateFincaUseCase, DeleteFincaUseCase, UpdateFincaUseCase, FindFincaUseCase,GetAllAvailableFincasUseCase {

    //TODO, OJO ACA , definan implementaciones por defecto porque sino FincaModelService se autoInyecta por ser el unico BEAN que implemente las 4 interfaces iniciales, generando depedencia CIRCULAR. impiendo que compile
    // TODAS las implementaciones tienen que llevar la anotacion "Service" sino no se reconoce como un BEAN y no es tomado como opcion para ser INYECTADO


    //TODO ojo aca, nose como sera en el ejemplo que tenemos de referencia pero no parece que este alineado a SOLID el hecho de un "UseCase" tenga mas de un metodo para mi no tiene sentido

    private final CreateFincaUseCase createFincaUseCase;
    private final DeleteFincaUseCase deleteFincaUseCase;
    private final UpdateFincaUseCase updateFincaUseCase;
    private final FindFincaUseCase findFincaUseCase;
    private final GetAllAvailableFincasUseCase getAllAvailableFincasUseCase;

    public FincaModelService(CreateFincaUseCase createFincaUseCase, DeleteFincaUseCase deleteFincaUseCase, UpdateFincaUseCase updateFincaUseCase, FindFincaUseCase findFincaUseCase, GetAllAvailableFincasUseCase getAllAvailableFincasUseCase){
        this.createFincaUseCase = createFincaUseCase;
        this.deleteFincaUseCase = deleteFincaUseCase;
        this.updateFincaUseCase = updateFincaUseCase;
        this.findFincaUseCase = findFincaUseCase;
        this.getAllAvailableFincasUseCase = getAllAvailableFincasUseCase;
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
    public Optional<Finca> getByUsername(String usename){
        return findFincaUseCase.getByUsername(usename);
    }

    @Override
    public List<Finca> getAll(){
        return findFincaUseCase.getAll();
    }

    @Override
    public Finca update(Finca finca){
        return updateFincaUseCase.update(finca);
    }

    @Override
    public List<Finca> getAllAvailableFincas() {return  getAllAvailableFincasUseCase.getAllAvailableFincas();}
}
