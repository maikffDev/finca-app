package com.finca.app.application.dto.FincaHourHnad;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FincaHourHandDTORequest {

    private Long hourHandId;
    private Long fincaId;

}
