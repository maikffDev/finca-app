package com.finca.app.infrastructure.mappers;

import com.finca.app.application.util.GenericErrorException;
import com.finca.app.domain.models.Finca;
import com.finca.app.infrastructure.entities.FincaEntity;
import com.finca.app.infrastructure.entities.UserEntity;
import com.finca.app.infrastructure.repositories.JpaFincaRepository;
import com.finca.app.infrastructure.repositories.JpaUserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDomainMapper {

    @Autowired
    public JpaUserRepository jpaUserRepository;

    @Mapping(source = "user.id", target = "user", qualifiedByName = "mapUserIdToUser")
    public abstract FincaEntity fromDomainModel(Finca finca);

    @Mapping(source = "user", target = "user")
    public abstract Finca toDomainModel(FincaEntity fincaEntity);

    public abstract List<FincaEntity> fromDomainModelList(List<Finca> fincas);

    @Named("mapUserIdToUser")
    protected UserEntity mapUserIdToUser(Long userId){
        return jpaUserRepository.findById(userId).orElseThrow(() -> new GenericErrorException("Can't create or update Finca. User '" + userId + "' not found."));
    }
}
