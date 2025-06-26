package com.finca.app.application.mappers;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.domain.models.HourHand;

public class HourHandDTOMapper {
        public static HourHandDTORequest toDTO(HourHandDTOResponse hourHand) {
            return new HourHandDTORequest(hourHand.getHourHandID(), hourHand.getDate(), hourHand.getStartTime(), hourHand.getEndTime());
        }

        public static HourHand toEntity(HourHandDTOResponse dto) {
            return new HourHand(dto.getHourHandID(), dto.getDate(), dto.getStartTime(), dto.getEndTime());
        }
}
