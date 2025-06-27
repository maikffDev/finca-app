package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "fincaHorarioID", nullable = false)
    private List<FincaHourHandEntity>fincaHourHandEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    private TypeOfSeasonEntity typeOfSeasonEntity;

    @OneToOne
    private TicketEntity ticketEntity;

    private boolean active;

    private LocalDate expirationDate;

}
