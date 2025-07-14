package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Image;
import com.finca.app.infrastructure.entities.ImageEntity;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ImageDomainMapper {

    @Autowired
    FincaDomainMapper fincaMapper;

    public ImageEntity toEntity(@NotNull  Image image) {

        ImageEntity entity = new ImageEntity();
        entity.setId(image.getId());
        entity.setUrlImage(image.getUrlImage());
        entity.setFinca(fincaMapper.fromDomainModel(image.getFinca()));

        return entity;
    }

    public  Image toDomain(@NotNull ImageEntity entity) {

        /*Image image = new Image();
        image.setId(entity.getId());
        image.setUrlImage(entity.getUrlImage());
        image.setFinca(fincaMapper.toDomainModel(entity.getFinca()));*/

        return Image.builder()
                .id(entity.getId())
                .urlImage(entity.getUrlImage())
                .finca(fincaMapper.toDomainModel(entity.getFinca()))
                .build();

    }
}

