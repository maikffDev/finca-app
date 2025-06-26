package com.finca.app.application.mappers;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.domain.models.HourHand;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HourHandDTOMapper {

    HourHand toModel(HourHandDTORequest dto);

    HourHandDTOResponse toDTO(HourHand model);

    List<HourHandDTOResponse> toDTOList(List<HourHand> models);
}
