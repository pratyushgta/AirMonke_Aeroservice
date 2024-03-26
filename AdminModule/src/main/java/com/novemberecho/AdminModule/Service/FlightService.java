package com.novemberecho.AdminModule.Service;

import com.novemberecho.AdminModule.DTO.FlightDto;
import com.novemberecho.AdminModule.Entity.Flight;
import com.novemberecho.AdminModule.Entity.Routes;
import com.novemberecho.AdminModule.Repository.FlightRepository;
import com.novemberecho.AdminModule.Repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Flight> getFlightbyCity(String arrival, String departure) {
        List<Flight> allFlights = flightRepository.findAll();
        List<Flight> responseFlightData = new ArrayList<>(); // Initialize the list

        for (int i = 0; i < allFlights.size(); i++) {
            if (allFlights.get(i).getArrival_city().equalsIgnoreCase(arrival) && allFlights.get(i).getDeparture_city().equalsIgnoreCase(departure)) {
                responseFlightData.add(allFlights.get(i));
            }
        }
        return responseFlightData;
    }
}
