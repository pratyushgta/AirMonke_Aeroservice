package com.novemberecho.AdminModule.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flight_id;
    private String flight_num;
    private String departure_time;
    private String arrival_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routes_id", referencedColumnName = "routes_id") //column name of routes id
    private Routes routes;
    private int total_seats;
}
