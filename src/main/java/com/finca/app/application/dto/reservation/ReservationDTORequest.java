package com.finca.app.application.dto.reservation;

import com.finca.app.application.dto.FincaHourHnad.FincaHourHandDTORequest;
import com.finca.app.application.dto.user.UserDtoRequest;
import com.finca.app.domain.models.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTORequest {


    @NotNull(message = "fincaHorario is required. An ID must be provided.")
    private List<FincaHourHandDTORequest> fincaHourHands;


    private Long userId;

    private Long fincaID;

}


/*private Boolean on = true;*/

    /*@NotNull(message = "Expiration is required. An ID must be provided.")
    private Date expiration;*/

    /*@NotNull(message = "An import is required")
    private BigDecimal totalCost;*/