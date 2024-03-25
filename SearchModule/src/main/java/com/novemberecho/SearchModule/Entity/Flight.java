package com.novemberecho.SearchModule.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "Flight", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departure_location;
    private String arrival_location;

    // to establish many-to-many relationship between User and roles. Unidirectional mapping
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //Eager means, whenever we want to retrieve user, we will also retrieve roles
    @JoinTable(
            name = "flight_data",
            joinColumns = @JoinColumn(
                    name = "route_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "plane_id", referencedColumnName = "flight_id"))

    private Collection<FlightData> flight;

    public Flight(){

    }
    public Flight(String departure_location, String arrival_location,
                  List<FlightData> flight) {
        super();
        this.departure_location = departure_location;
        this.arrival_location = arrival_location;
        this.flight = flight;
    }
}
