package com.finca.app.domain.models;

import java.time.LocalDate;

public class Ticket {
    private Long id;

    private double total;

    private PaymentMethod paymentMethod;

    private State state;

    private LocalDate paymentDate;
}
