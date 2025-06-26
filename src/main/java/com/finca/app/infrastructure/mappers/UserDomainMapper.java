package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.User;
import com.finca.app.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "correo"),
            @Mapping(source = "password", target = "contrasena"),
            @Mapping(source = "enabled", target = "activo")
    })
    UserEntity fromDomainModel(User user);

    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "activo", target = "enabled")
    })
    User toDomainModel(UserEntity userEntity);

    List<UserEntity> fromDomainModelList(List<User> users);

    List<User> toDomainModelList(List<UserEntity> userEntities);
}