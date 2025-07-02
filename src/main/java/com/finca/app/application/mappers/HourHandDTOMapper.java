package com.finca.app.application.mappers;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.domain.models.HourHand;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class HourHandDTOMapper {

    public abstract HourHand toModel(HourHandDTORequest dto);

    public abstract HourHandDTOResponse toDTO(HourHand model);

    public abstract List<HourHandDTOResponse> toDTOList(List<HourHand> models);
}
