package com.novemberecho.AdminModule.Controller;

import com.novemberecho.AdminModule.Entity.Flight;
import com.novemberecho.AdminModule.Entity.Payment;
import com.novemberecho.AdminModule.Entity.Routes;
import com.novemberecho.AdminModule.Service.FlightService;
import com.novemberecho.AdminModule.Service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    /*@GetMapping("/fetch/{arrival}/{departure}")
    public ResponseEntity<List<Flight>> fetchFlightData(@PathVariable String arrival, String departure) {
        List<Flight> flightData = flightService.getFlightbyCity(arrival, departure);
        System.out.println(flightData);
        return new ResponseEntity<>(flightData, HttpStatus.CREATED);
    }*/

    @GetMapping("/fetch-all-flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> list = flightService.getAllFlights();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/fetch-all-routes")
    public ResponseEntity<List<Routes>> getAllRoutes() {
        List<Routes> list = routesService.getAllRoutes();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/fetch/{arrival}/{departure}")
    public ResponseEntity<List<Flight>> getRoutebyCity(@PathVariable("arrival") String arrival, @PathVariable("departure") String departure) {
        List<Flight> list = flightService.getAllFlights();
        List<Flight> response = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getArrival_city().equalsIgnoreCase(arrival) && list.get(i).getDeparture_city().equalsIgnoreCase(departure)) {
                response.add(list.get(i));
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search-flights/{routeFrom}/{routeTo}")
    public ResponseEntity<List<Flight>> searchFlights(@PathVariable String routeFrom,
                                                      @PathVariable String routeTo) {

        List<Flight> flights = flightService.getFlightbyCity(routeFrom, routeTo);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
    @PostMapping("/modifypricessave")
    public ResponseEntity<Payment> modifypricessave(@ModelAttribute Payment data){
        System.out.println(data.getArrival_city());
        String url="http://payment:8084/payment/data/"+data.getDeparture_city()+"/"
                +data.getArrival_city()+"/"+data.getPrice();
        restTemplate.postForObject(url,data,String.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/ms2")
    public String Microservice2Response() {
        return "Output from Microservice 2";
    }
}
