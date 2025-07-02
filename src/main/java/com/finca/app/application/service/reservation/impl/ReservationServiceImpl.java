package com.finca.app.application.service.reservation.impl;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.dto.reservation.ReservationDTOResponse;
import com.finca.app.application.mappers.ReservationDTOMapper;
import com.finca.app.application.service.reservation.ReservationService;
import com.finca.app.domain.models.Reservation;
import com.finca.app.infrastructure.exceptions.GenericErrorException;
import com.finca.app.infrastructure.exceptions.GenericNoContentException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class ReservationServiceImpl implements ReservationService {

    private final ReservationModelService reservationModelService;
    private final ReservationDTOMapper reservationDTOMapper;
    //private final ReservationDTOMapper reservationDTOMapper2 = new ReservationDTOMapper2;


    public ReservationServiceImpl(ReservationModelService reservationModelService, ReservationDTOMapper reservationDTOMapper){
        this.reservationDTOMapper = reservationDTOMapper;
        this.reservationModelService = reservationModelService;

    }

    @Override
    public ReservationDTOResponse create(ReservationDTORequest reservationDTORequest) {
        //Reservation reservation = reservationDTOMapper.toModel(reservationDTORequest);
        Reservation newReservation = reservationModelService.create(reservationDTORequest);
        return reservationDTOMapper.toDto(newReservation);

    }



    @Override
    public List<ReservationDTOResponse> getAll() {
        List<Reservation> reservations = reservationModelService.getAll();
        if(reservations.isEmpty()){
            throw new GenericNoContentException("No reservations were found");
        }
        return reservationDTOMapper.toDtoList(reservations);
    }

    @Override
    public ReservationDTOResponse getById(Long reservationID) {
        Optional<Reservation> reservation = reservationModelService.getById(reservationID);
        if(!reservation.isPresent()) throw new RuntimeException("There's no reservation with that Id");
        return reservationDTOMapper.toDto(reservation.get());
    }

    @Override
    public ReservationDTOResponse update(Long reservationId, ReservationDTORequest ReservationDtoToUpdate) {
        /*Reservation reservation = reservationModelService.getById(reservationId).orElseThrow(() -> new GenericErrorException("CANNOT UPDATE. Reservation with id '" + reservationId + "' not found."));
        Reservation reservationToUpdate = reservationDTOMapper.toModel(ReservationDtoToUpdate);
        reservation.setUserID(reservationToUpdate.getUserID());
        reservation.setFincaHorarioID(reservationToUpdate.getFincaHorarioID());
        reservation.setTicket(reservationToUpdate.getTicket());
        reservation.setFincaHorarioID(reservationToUpdate.getFincaHorarioID());
        reservation.setTotalCost(reservationToUpdate.getTotalCost());
        reservation.setOn(reservationToUpdate.getOn());
        reservation.setFinalState(reservationToUpdate.getFinalState());
        Reservation updatedReservation = reservationModelService.update(reservation);
        return reservationDTOMapper.toDto(updatedReservation);*/
        return null;
    }

    @Override
    public ReservationDTOResponse delete(Long id) {
        Reservation reservation = reservationModelService.getById(id).orElseThrow(() -> new GenericErrorException("CANNOT DELETE. Reservation with id '" + id + "' not found."));
        Boolean isDelete = reservationModelService.delete(id);
        if (isDelete == true){
            return reservationDTOMapper.toDto(reservation);
        }
        throw new GenericErrorException("CANNOT DELETE. Something went wrong during the process. Try again.");
    }

    @Override
    public ReservationDTOResponse logicalDeletion(Long id) {
        Reservation reservation= reservationModelService.getById(id).orElseThrow(() -> new GenericErrorException("CANNOT DISABLE. Reservation with id '" + id + "' not found."));
        reservation.setOn(false);
        Reservation disableReservation = reservationModelService.logicalDeletion(reservation);
        return reservationDTOMapper.toDto(disableReservation);
    }
}

