package com.finca.app.infrastructure.mappers;

import com.finca.app.domain.models.Image;
import com.finca.app.infrastructure.entities.ImageEntity;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ImageDomainMapper {

    //TODO parece que no es posible insertar NotNull. ya que funciona con BEANS nomas y al declarar los mappers como "Mappers" quedan fuera del scope y aparte les falta anotaciones para ser detectado como bean por ende por mas que te deje NO funcionaria, por eso agregue validaciones manueales en el mapeado manual

    @Autowired
    @Lazy
    FincaDomainMapper fincaMapper;

    public ImageEntity toEntity(Image image) {

        ImageEntity entity = new ImageEntity();
        entity.setId(image.getId());
        entity.setUrlImage(image.getUrlImage());
         entity.setFinca(fincaMapper.fromDomainModel(image.getFinca()));

        return entity;
    }

    public ImageEntity toEntity2(Image image) {

        ImageEntity entity = new ImageEntity();
        entity.setId(image.getId());
        entity.setUrlImage(image.getUrlImage());


        return entity;
    }

    public  Image toDomain(ImageEntity entity) {

        return Image.builder()
                .id(entity.getId())
                .urlImage(entity.getUrlImage())
                .finca(fincaMapper.toDomainModel(entity.getFinca()))
                .build();

    }

    public  Image toDomain2(ImageEntity entity) {

        return Image.builder()
                .id(entity.getId())
                .urlImage(entity.getUrlImage())
                .build();

    }

    public List<Image> fromEntitiesToDomains(List<ImageEntity> entities) {
        if (entities == null || entities.isEmpty()) return Collections.emptyList();

        return entities.stream()
                .map(this::toDomain2)
                .collect(Collectors.toList());
    }
}

