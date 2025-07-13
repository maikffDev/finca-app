package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.finca.FincaDTOResponse;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Image;
import com.finca.app.infrastructure.mappers.ImageDomainMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ImageDTOMapper.class })
public abstract class FincaDTOMapper {

    @Autowired
    ImageDTOMapper imageDTOMapper;

    public abstract Finca toModel(FincaDTORequest fincaDto);

    @Mapping(source = "images", target = "images", qualifiedByName = "mapImagesToUrls")
    public abstract FincaDTOResponse toDto(Finca finca);


    public abstract List<FincaDTOResponse> toDtoList(List<Finca> finca);

    @Named("fromDomainToDtoResponseManual")
    public  FincaDTOResponse fromDomainToDtoResponseManual(Finca finca){

        List<String> imagesUrls = imageDTOMapper.toOnlyUrls(finca.getImages());

        return FincaDTOResponse.builder()
                .id(finca.getId())
                .name(finca.getName())
                .location(finca.getUbication())
                .pricePerHour(finca.getPricePerHour())
                .active(finca.isActive())
                .images(imagesUrls)
                .build();

    };

    @Named("mapImagesToUrls")
    public List<String> map(List<Image> images) {
        return imageDTOMapper.toOnlyUrls(images);
    }
}
