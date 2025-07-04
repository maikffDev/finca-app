package com.finca.app.application.mappers;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.image.ImageDTORequest;
import com.finca.app.application.dto.image.ImageDTOResponse;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Image;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ImageDTOMapper {

    @Autowired
    FincaDTOMapper fincaDTOMapper;


    public  ImageDTOResponse fromDomainToDTOResponse(@NotNull Image image) {

        ImageDTOResponse dto = new ImageDTOResponse();
        dto.setId(image.getId());
        dto.setUrlImage(image.getUrlImage());
        return dto;
    }

    public  Image fromDTOResponseToDomain(@NotNull ImageDTOResponse dto) {

        return Image.builder()
                .id(dto.getId())
                .urlImage(dto.getUrlImage())
                .build();
    }


    public  Image fromDTORequestToDomain(@NotNull  ImageDTORequest dto) {

        return Image.builder()
                .id(dto.getId())
                .build();
    }

    public  Image fromDTORequestToNewDomain(FincaDTORequest fincaDtoRequest, String urlImagee) {

        return Image.builder()
                .finca(fincaDTOMapper.toModel(fincaDtoRequest))
                .urlImage(urlImagee)
                .build();
    }

    /*public  List<ImageDTOResponse> toDTOResponseList(@NotNull  List<Image> images) {
        return images.stream()
                .map(ImageDTOMapper::fromDomainToDTOResponse)
                .collect(Collectors.toList());
    }*/
}
