package com.finca.app.application.service.finca_HourHand;

import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTORequest;
import com.finca.app.application.dto.finca_HourHand.Finca_HourHandDTOResponse;
import com.finca.app.domain.models.Finca_HourHand;

import java.util.List;
import java.util.Optional;

public interface Finca_HourHandService {

    /* ---------- CRUD ---------- */
    Finca_HourHandDTOResponse create(Finca_HourHandDTORequest fincaHourHand);
    Finca_HourHandDTOResponse update(Finca_HourHandDTORequest fincaHourHand);      // DTO trae el id
    Finca_HourHandDTOResponse update(Long id, Finca_HourHandDTORequest dto);      // id por parámetro
    Finca_HourHandDTOResponse delete(Long fincaHourHandId);
    Finca_HourHandDTOResponse logicalDeletion(Finca_HourHand fincaHourHand);

    /* ---------- QUERIES ---------- */
    Optional<Finca_HourHandDTOResponse> getById(Long fincaHourHandId);            // 1 resultado
    List<Finca_HourHandDTOResponse>       getAll();                               // muchos resultados
    List<Finca_HourHandDTOResponse>       getByFincaId(Long fincaId);             // muchos resultados
    List<Finca_HourHandDTOResponse>       getByHourHandId(Long hourHandId);       // muchos resultados
}
