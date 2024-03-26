package com.novemberecho.AdminModule.DTO;

import com.novemberecho.AdminModule.Entity.Routes;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flight_id;
    private String flight_num;
    private String departure_time;
    private String arrival_time;
    private int routes_id_arrival;
    private int routes_id_departure;
    private int total_seats;
    private String departure_city;
    private String arrival_city;
}
