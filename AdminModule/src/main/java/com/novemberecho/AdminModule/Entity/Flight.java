package com.novemberecho.AdminModule.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flight_id;
    private String flight_num;
    private String departure_time;
    private String arrival_time;
    private String departure_city;
    private String arrival_city;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_routes_id", referencedColumnName = "routes_id") //column name of routes id
    private Routes arrival_routes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_routes_id", referencedColumnName = "routes_id") //column name of routes id
    private Routes departure_routes;
    private int total_seats;
}
