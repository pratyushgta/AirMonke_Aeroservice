package com.novemberecho.BookingModule.Controller;

import com.novemberecho.BookingModule.Entity.Flight;
import com.novemberecho.BookingModule.Service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book")
public class REST_BookingController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RoutesService routesService;
    @GetMapping("/fetch")
    public ResponseEntity<List<Flight>> searchFlight() {
        ResponseEntity<Flight[]> response = restTemplate.getForEntity(
                "http://AdminModule:8082/admin/all",
                Flight[].class
        );

        Flight[] flightsArray = response.getBody();
        List<Flight> flightList = Arrays.asList(flightsArray);
        return new ResponseEntity<>(flightList, HttpStatus.OK);
    }


    @GetMapping("/ms1")
    public String display() {
        String microservice2Response = restTemplate.getForObject("http://AdminModule:8082/admin/ms2", String.class);
        return "Output from Microservice 1 & " + microservice2Response;
    }

    @GetMapping("/ms11")
    public String display2() {
        return "Output from Microservice 1 & ";
    }
}
