package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.application.services.user.impl.UserModelService;
import com.finca.app.application.util.GenericErrorException;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDTOMapper {

    @Autowired
    UserModelService userModelService;

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    public abstract Finca toModel(FincaDTORequest fincaDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "user")
    public abstract FincaDTOResponse toDto(Finca finca);

    public abstract List<FincaDTOResponse> toDtoList(List<Finca> fincas);

    @Named("mapUserIdToUser")
    protected User mapUserIdToUser(Long userId){
        return userModelService.getById(userId).orElseThrow(() -> new GenericErrorException("Can't create or update Finca. User '" + userId + "' not found."));
    }
}
