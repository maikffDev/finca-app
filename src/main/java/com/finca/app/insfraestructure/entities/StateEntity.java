package com.finca.app.insfraestructure.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany
    @JoinColumn(name = "ticket_id", nullable = false)
    private List<TicketEntity> tickets = new ArrayList<>();
}
