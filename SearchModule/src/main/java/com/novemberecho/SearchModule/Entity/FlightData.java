package com.novemberecho.SearchModule.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
//@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class FlightData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_id;
    private int flight_number;
    private String departure_time;
    private String arrival_time;

    public FlightData() {

    }

    public FlightData(int flight_number, String departure_time, String arrival_time) {
        super();
        this.flight_number = flight_number;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }
}

