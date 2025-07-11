package com.finca.app.application.mappers;

import com.finca.app.application.dto.amenitie.AmenitieDTORequest;
import com.finca.app.application.dto.amenitie.AmenitieDTOResponse;
import com.finca.app.domain.models.Amenitie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AmenitieDTOMapper {
    Amenitie toModel(AmenitieDTORequest request);
    AmenitieDTOResponse toDto(Amenitie model);
    List<AmenitieDTOResponse> toDtoList(List<Amenitie> models);
}