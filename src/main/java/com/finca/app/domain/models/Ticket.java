package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Long id;

    private double total;

    private PaymentMethod paymentMethod;

    private State state;

    private LocalDate paymentDate;
}
