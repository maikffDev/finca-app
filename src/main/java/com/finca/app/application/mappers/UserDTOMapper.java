package com.finca.app.application.mappers;
import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.application.dto.user.UserDtoResponse;
import com.finca.app.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;


@Mapper
public abstract class UserDTOMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "Activo", target = "activo"),
            @Mapping(source = "rollId", target = "rollId")
    })
            public abstract User toModel(UserDtoRequest dto);

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "activo", target = "activo"),
            @Mapping(source = "rollId", target = "rollId")
    })
    public abstract  UserDtoResponse toDto(User user);

    public abstract List<UserDtoResponse> toDtoList(List<User> users);

}
