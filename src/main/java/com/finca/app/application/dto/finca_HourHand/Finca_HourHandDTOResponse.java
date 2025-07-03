package com.finca.app.application.dto.finca_HourHand;

import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.HourHand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Finca_HourHandDTOResponse {
    private Long fincaHourHandId;
    private HourHand hourHandId;
    private LocalTime hourHandStartTime;
    private LocalTime hourHandEndTime;
    private Finca fincaId;
    private Double tarifaPorHora;
    private Boolean reservado;
}
