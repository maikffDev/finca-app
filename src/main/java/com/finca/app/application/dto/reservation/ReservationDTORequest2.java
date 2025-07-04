package com.finca.app.application.dto.reservation;

import com.finca.app.application.dto.FincaHourHnad.FincaHourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.domain.models.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ReservationDTORequest2 {

    private List<Long> fincaHourHands;

    private Long userId;

    private Long fincaID;


}
