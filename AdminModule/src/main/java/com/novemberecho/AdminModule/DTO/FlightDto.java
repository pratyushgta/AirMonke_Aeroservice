package com.novemberecho.AdminModule.DTO;

import com.novemberecho.AdminModule.Entity.Routes;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class FlightDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flight_id;
    private String flight_num;
    private String departure_time;
    private String arrival_time;
    private int routes_id;
    private int total_seats;
}