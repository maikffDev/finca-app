package com.finca.app.application.dto.reservation;

import com.finca.app.domain.models.Horario;
import com.finca.app.domain.models.TypeOfSeason;
import com.finca.app.domain.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTOResponse {
    private Long reservationID;
    private Horario fincaHorarioID;
    private Usuario userID;
    private TypeOfSeason typeOfSeason;
    private Boolean on;
    private Date expiration;
}
