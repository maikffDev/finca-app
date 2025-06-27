package com.finca.app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commentary {

   private User user;
   private Finca finca;
   private Reservation reservation;
   private String description;

}
