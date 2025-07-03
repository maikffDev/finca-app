package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "reservation_entity")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "reservation_id") // FK en finca_hour_hand_entity
    private List<FincaHourHandEntity> fincaHourHandEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne(mappedBy = "reservationEntity", cascade = CascadeType.ALL)
    private TicketEntity ticketEntity;

    private boolean active;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<StateHistoryEntity> stateHistoryEntity;
}
