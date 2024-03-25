package com.novemberecho.SearchModule.Repository;

import com.novemberecho.SearchModule.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightSearchRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByDeparture_location(@Param("departure_location") String departure_location, @Param("arrival_location") String arrival_location);

    List<Flight> findByFlight_Id(@Param ("flight_id")int flight_id );
}
