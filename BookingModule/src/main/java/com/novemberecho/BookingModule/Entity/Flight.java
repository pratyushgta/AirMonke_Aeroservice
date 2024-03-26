package com.novemberecho.BookingModule.Entity;

import com.novemberecho.AdminModule.Entity.Routes;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flight_id;
    private String flight_num;
    private String departure_time;
    private String arrival_time;
    private String departure_city;
    private String arrival_city;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_routes_id", referencedColumnName = "routes_id") //column name of routes id
    private com.novemberecho.AdminModule.Entity.Routes arrival_routes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_routes_id", referencedColumnName = "routes_id") //column name of routes id
    private Routes departure_routes;
    private int total_seats;
}
