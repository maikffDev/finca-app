package com.finca.app.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany
    @JoinColumn(name = "ticket_id", nullable = false)
    private List<TicketEntity> tickets = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "stateHistoryId")
    private List<StateHistoryEntity> stateHistoryEntity;
}
