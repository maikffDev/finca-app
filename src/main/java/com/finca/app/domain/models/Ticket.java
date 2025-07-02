package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    private Long id;

    private double total;

    private String paymentMethod;

    private LocalDate paymentDate;
}
