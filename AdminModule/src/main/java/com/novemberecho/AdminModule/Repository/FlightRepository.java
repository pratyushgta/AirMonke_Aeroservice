package com.novemberecho.AdminModule.Repository;

import com.novemberecho.AdminModule.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    //List<Flight> findAllByRoutes_id(int id);
}
