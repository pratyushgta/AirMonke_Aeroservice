package com.novemberecho.AdminModule.Controller;

import com.novemberecho.AdminModule.Entity.Flight;
import com.novemberecho.AdminModule.Service.FlightService;
import com.novemberecho.AdminModule.Service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class REST_AdminController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RoutesService routesService;

    @Autowired
    FlightService flightService;

    // FETCH BY BOOKING MODULE
    @GetMapping("/fetch/{arrival}/{departure}")
    public ResponseEntity<List<Flight>> fetchFlightData(@PathVariable String arrival, String departure) {
        List<Flight> flightData = flightService.getFlightbyCity(arrival, departure);
        System.out.println(flightData);
        return new ResponseEntity<>(flightData, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllEmployees() {
        List<Flight> list = flightService.getAllFlights();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/ms2")
    public String Microservice2Response() {
        return "Output from Microservice 2";
    }
}
