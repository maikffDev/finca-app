package com.finca.app.infrastructure.entities;


import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.models.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "state_history_entity")
public class StateHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity state;

    @ManyToOne
    @JoinColumn(name = "reservation_id" , nullable = false)
    private ReservationEntity reservation;

    private LocalDate fecha;
}


