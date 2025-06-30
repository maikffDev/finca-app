package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.User;
import com.finca.app.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {

    /*@Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "email", target = "correo"),
            @Mapping(source = "password", target = "contrasena"),
            @Mapping(source = "enabled", target = "activo")
    })
    UserEntity fromDomainModel(User user);*/

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "username", target = "nombre"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "contrasena", target = "contrasena"),
            @Mapping(source = "activo", target = "activo")
    })
    UserEntity fromDomainModel(User user);

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "nombre", target = "username"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "contrasena", target = "contrasena"),
            @Mapping(source = "activo", target = "activo")
    })
    User toDomainModel(UserEntity userEntity);

    List<UserEntity> fromDomainModelList(List<User> users);

    List<User> toDomainModelList(List<UserEntity> userEntities);
}