package com.finca.app.infrastructure.adapters;

import com.finca.app.application.dto.reservation.ReservationDTORequest;
import com.finca.app.application.mappers.FincaHourHandMapper;
import com.finca.app.application.mappers.HourHandDTOMapper;
import com.finca.app.application.mappers.ReservationDTOMapper;
import com.finca.app.domain.models.Finca;
import com.finca.app.domain.models.Finca_HourHand;
import com.finca.app.domain.models.HourHand;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.out.ReservationModelPort;
import com.finca.app.infrastructure.entities.ReservationEntity;
import com.finca.app.infrastructure.mappers.ReservationDomainMapper;
import com.finca.app.infrastructure.repositories.JpaReservationRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationModelAdapter implements ReservationModelPort {


    private final JpaReservationRepository jpaReservationRepository;
    private final ReservationDomainMapper reservationDomainMapper;
    private final ReservationDTOMapper reservationDTOMapper;
    private final FincaHourHandMapper fincaHourHandMapper;

    public ReservationModelAdapter(JpaReservationRepository jpaReservationRepository, ReservationDomainMapper reservationDomainMapper, ReservationDTOMapper reservationDTOMapper, FincaHourHandMapper fincaHourHandMapper) {
        this.jpaReservationRepository = jpaReservationRepository;
        this.reservationDomainMapper = reservationDomainMapper;
        this.reservationDTOMapper = reservationDTOMapper;
        this.fincaHourHandMapper = fincaHourHandMapper;
    }


    @Override
    public Reservation create(ReservationDTORequest reservationDTO) {

        LinkedList<Finca_HourHand> fincasHourHand= (LinkedList<Finca_HourHand>) fincaHourHandMapper.fromDTOsToModels(reservationDTO.getFincaHourHands());
        BigDecimal total = estimateTotal(fincasHourHand);
        Reservation newReservation = reservationDTOMapper.fromDTOtoNewModel(reservationDTO,total,fincasHourHand);
        return newReservation;
    }

    @Override
    public Reservation save(@NotNull Reservation reservationModel) {

        ReservationEntity reservationEntity =null;
        Reservation savedReservation=null;
        try{
            reservationEntity =reservationDomainMapper.fromModelToEntity(reservationModel);
            reservationEntity = jpaReservationRepository.save(reservationEntity);
            savedReservation= reservationDomainMapper.fromEntityToModel(reservationEntity);
        }catch (Exception e){
            throw new RuntimeException("Error saving a new Reservation : "+e.getMessage());
        }

        return savedReservation;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return List.of();
    }

    @Override
    public Optional<Reservation> findByReservationID(Long userID) {
        return Optional.empty();
    }

    @Override
    public Reservation logicalDeletion(Reservation reservation) {
        return null;
    }

    @Override
    public Optional<Reservation> findByUserId(Long id) {
        return Optional.empty();
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    private BigDecimal estimateTotal(List<Finca_HourHand> fincasHourHand){
        BigDecimal total= BigDecimal.valueOf(0);
        int preTotal=0;
        int horasDeEstadiaDelHorario=0;
        HourHand horario=null;
        Finca finca=null;

        for (Finca_HourHand fincaHourHand : fincasHourHand) {
            finca = fincaHourHand.getFinca();
            horario = fincaHourHand.getHourHand();
            horasDeEstadiaDelHorario = (int) Duration.between(horario.getStartTime(), horario.getEndTime()).toHours();
            preTotal += (int) (finca.getPricePerHour() * horasDeEstadiaDelHorario);
        }

        return BigDecimal.valueOf(preTotal);
    }

}
