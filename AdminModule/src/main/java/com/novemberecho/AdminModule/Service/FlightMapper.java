package com.novemberecho.AdminModule.Service;

import com.novemberecho.AdminModule.DTO.FlightDto;
import com.novemberecho.AdminModule.Entity.Flight;
import com.novemberecho.AdminModule.Entity.Routes;

/**
 * This class contains methods for mapping DTO to Entity and vice-versa
 * MSA-E2
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */
public class FlightMapper {
    public static FlightDto mapToFlightDTO(Flight flight) {
        FlightDto flightDto = new FlightDto(
                flight.getFlight_id(),
                flight.getFlight_num(),
                flight.getDeparture_time(),
                flight.getArrival_time(),
                flight.getArrival_routes().getRoutes_id(),
                flight.getDeparture_routes().getRoutes_id(),
                flight.getTotal_seats(),
                flight.getDeparture_city(),
                flight.getArrival_city()
        );
        return flightDto;
    }

   /* public static FlightDto mapToFlight(FlightDto flightDTO) {
        Flight flight = new Flight(
              flightDTO.getFlight_id(),
                flightDTO.getFlight_num(),
                flightDTO.getDeparture_time(),
                flightDTO.getArrival_time(),
                flightDTO.getDeparture_city(),
                flightDTO.getArrival_city(),

                flightDTO.getRoutes_id_departure(),
                flightDTO.getTotal_seats()
        );

        return flight;
    }*/
}

