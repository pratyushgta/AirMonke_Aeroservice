package com.novemberecho.AdminModule.Service;

import com.novemberecho.AdminModule.Entity.Flight;
import com.novemberecho.AdminModule.Entity.Routes;
import com.novemberecho.AdminModule.Repository.FlightRepository;
import com.novemberecho.AdminModule.Repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void deleteFlightbyID(int id) {
        flightRepository.deleteById(id);
    }

    public Optional<Flight> getFlightbyID(int id) {
        return flightRepository.findById(id);
    }



    /*public List<Flight> getAllFlightByRoute(int id) {
        return flightRepository.findAllByRoutes_id(id);
    }*/
}
