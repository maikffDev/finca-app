package com.finca.app.infrastructure.adapters;

import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.application.mappers.FincaHourHandMapper;
import com.finca.app.application.mappers.ReservationDTOMapper;
import com.finca.app.application.service.user.UserService;
import com.finca.app.application.service.util.GenericErrorException;
import com.finca.app.domain.models.*;
import com.finca.app.domain.ports.out.ReservationModelPort;
import com.finca.app.infrastructure.entities.FincaHourHandEntity;
import com.finca.app.infrastructure.entities.ReservationEntity;
import com.finca.app.infrastructure.entities.TicketEntity;
import com.finca.app.infrastructure.mappers.FincaHourHandDomainMapper;
import com.finca.app.infrastructure.mappers.ReservationDomainMapper;
import com.finca.app.infrastructure.repositories.JpaFincaHourHandRepository;
import com.finca.app.infrastructure.repositories.JpaReservationRepository;
import com.finca.app.infrastructure.repositories.JpaTicketRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationModelAdapter implements ReservationModelPort {

    private final JpaReservationRepository jpaReservationRepository;
    private final ReservationDomainMapper reservationDomainMapper;
    private final ReservationDTOMapper reservationDTOMapper;
    private final FincaHourHandMapper fincaHourHandMapper;
    private final UserService userService;

    @Autowired
    JpaTicketRepository jpaTicketRepository;

    @Autowired
    JpaFincaHourHandRepository fincaHourHandRepository;

    @Autowired
    FincaHourHandDomainMapper fincaHourHandDomainMapper;

    public ReservationModelAdapter(JpaReservationRepository jpaReservationRepository, ReservationDomainMapper reservationDomainMapper, ReservationDTOMapper reservationDTOMapper, FincaHourHandMapper fincaHourHandMapper, UserService userService) {
        this.jpaReservationRepository = jpaReservationRepository;
        this.reservationDomainMapper = reservationDomainMapper;
        this.reservationDTOMapper = reservationDTOMapper;
        this.fincaHourHandMapper = fincaHourHandMapper;
        this.userService = userService;
    }

    @Override
    public Reservation create(ReservationDTORequest2 reservationDTO) {
        Reservation newReservation =null;

        try {
            List<FincaHourHandEntity> fincasHourHandEntities= fincaHourHandRepository.findAllByIdIn(reservationDTO.getFincaHourHands()); //TODO ACOMODAR A DONDE CORRESPONDE
            List<Finca_HourHand> fincasHourHand = fincaHourHandDomainMapper.fromEntitiesToModels(fincasHourHandEntities);
            BigDecimal total = estimateTotal(fincasHourHand);
            User user = userService.getEntityById(reservationDTO.getUserId());
            LocalDate expiration = fincasHourHand.getFirst().getHourHand().getDate();
            newReservation = reservationDTOMapper.fromDTOtoNewModel(total,user,expiration);
        }catch (Exception e){
            throw new RuntimeException("error en ReservationModelAdapter , el metodo create .stack trace :"+e.getMessage());
        }

        return newReservation;
    }

    /*@Override
    public Reservation create(ReservationDTORequest2 reservationDTO) {
        Reservation newReservation =null;

        try {
            List<Finca_HourHand> fincasHourHand= fincaHourHandMapper.fromDTOsToModels(reservationDTO.getFincaHourHands());
            BigDecimal total = estimateTotal(fincasHourHand);
            Optional<FincaHourHandEntity> fincaHorarioValidado = fincaHourHandRepository.findByFinca_IdAndHourHandEntity_Id(fincasHourHand.getFirst().getFinca().getId(),fincasHourHand.getFirst().getHourHand().gethourHandID() );  // TODO, corregir y setear en el lugar correcto del caso de uso antes de mostrar
            Finca_HourHand fincaHourHandModel= fincaHourHandDomainMapper.fromEntityToModel(fincaHorarioValidado.orElseThrow());
            User user = userService.getEntityById(reservationDTO.getUserId());
            newReservation = reservationDTOMapper.fromDTOtoNewModel(reservationDTO,total,fincaHourHandModel,user);
        }catch (Exception e){
            throw new RuntimeException("error en ReservationModelAdapter , el metodo create .stack trace :"+e.getMessage());
        }

        return newReservation;
    }*/



    @Override
    public Reservation addTicketToReservation(Reservation reservation, Ticket ticket) {
        reservation.setTicket(ticket);
        return reservation;
    }

    @Override
    public ReservationEntity addTicketToReservation(ReservationEntity reservation, Ticket ticket) {
        TicketEntity ticketEntity = jpaTicketRepository.findById(ticket.getId()).orElseThrow();
        reservation.setTicketEntity(ticketEntity);
        return reservation;
    }

    @Override
    public ReservationEntity validateReservation(Reservation reserve, ReservationDTORequest2 reservationDTO) {

        List<FincaHourHandEntity> horariosEntity= fincaHourHandRepository.findAllByIdIn(reservationDTO.getFincaHourHands()); ;

        return reservationDomainMapper.fromModelToEntity(reserve,horariosEntity);
    }



    @Override
    public Reservation save(@NotNull ReservationEntity reservationEntity) {
        Reservation savedReservation=null;
        try{
            reservationEntity =jpaReservationRepository.save(reservationEntity);
            savedReservation  =reservationDomainMapper.fromEntityToModel(reservationEntity);
        }catch (Exception e){
            throw new RuntimeException("error en ReservationModelAdapter  el metodo 'save' .stacktrace: "+e.getMessage());
        }

        return savedReservation;
    }

    @Override
    public ReservationEntity save2(@NotNull ReservationEntity reservationEntity) {
        Reservation savedReservation=null;
        try{
            reservationEntity =jpaReservationRepository.save(reservationEntity);

        }catch (Exception e){
            throw new RuntimeException("error en ReservationModelAdapter  el metodo 'save' .stacktrace: "+e.getMessage());
        }

        return reservationEntity;
    }

    @Override
    public Reservation save(@NotNull Reservation reservationModel) {

        ReservationEntity reservationEntity =null;
        Reservation savedReservation=null;
        try{
            reservationEntity =reservationDomainMapper.fromModelToEntity(reservationModel);
            reservationEntity =jpaReservationRepository.save(reservationEntity);
            savedReservation  =reservationDomainMapper.fromEntityToModel(reservationEntity);
        }catch (Exception e){
            throw new RuntimeException("error en ReservationModelAdapter  el metodo 'save' .stacktrace: "+e.getMessage());
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

    private BigDecimal estimateTotal(@NotNull  List<Finca_HourHand> fincasHourHand){
        BigDecimal total= BigDecimal.valueOf(0);
        int preTotal=0;
        int duracionDeLaEstadia =0;
        HourHand horario=null;
        Finca finca=null;

        try {
            for (Finca_HourHand fincaHourHand : fincasHourHand) {

                finca = fincaHourHand.getFinca();
                horario = fincaHourHand.getHourHand();
                mostrarHorario(horario);
                duracionDeLaEstadia = (int) Duration.between(horario.getArrivalTime(), horario.getDepartureTime()).toHours();
                preTotal += (int) (finca.getPricePerHour() * duracionDeLaEstadia);
            }
        }catch (Exception e){
            throw new GenericErrorException("Error en estimateTotal , : "+e.getMessage());
        }

        return BigDecimal.valueOf(preTotal);
    }

    public void mostrarHorario(HourHand horario){
        if(horario==null) System.out.println( "horario Nulo");
        System.out.println("fecha: " +horario.getDate());
        System.out.println("Hora inicio :"+horario.getArrivalTime());
        System.out.println("Hora salida :"+horario.getDepartureTime());

    }

}

//System.out.println();
