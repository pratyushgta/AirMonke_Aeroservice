package com.novemberecho.SearchModule.Controller;


import com.novemberecho.SearchModule.Entity.Flight;
import com.novemberecho.SearchModule.Entity.FlightData;
import com.novemberecho.SearchModule.Repository.FlightDataRepository;
import com.novemberecho.SearchModule.Repository.FlightSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/search")
public class MainController {
    @RequestMapping("/display")
    String display() {
        return "Search Hello World";
    }
    /*@GetMapping("/home")
    public String home() {
        return "X_homePage";
    }*/

    /*@GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        return "X_homePage"; // Display anonymous info
    }

    @GetMapping
    public String currentUser(@ModelAttribute("user") BindingResult result, Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if (loggedInUser != null && loggedInUser.isAuthenticated()) {
            String email = loggedInUser.getName();
            return "X_homePage"; // Display logged in user info
        } else {
            return "X_homePage"; // Display anonymous info
        }
    }*/

    @Autowired
    public FlightSearchRepository flightSearchRepository;
    @Autowired
    public FlightDataRepository flightDataRepository;

    @Autowired
    public FlightSearchRepository frepo;
    @Autowired
    public FlightDataRepository fdrepo;
    //Getting List Of all flights

    @GetMapping("/allFlights")
    public List<Flight> getAllFlights() {
        return frepo.findAll();
    }

    //Getting list of Flight from location to destination

    @GetMapping("/find/{departure_location}/{arrival_location}")
    public List<Flight> getFlightByData(@PathVariable("departure_location") String dep_loc, @PathVariable("arrival_location") String arr_loc) {
        return frepo.findByDeparture_location(dep_loc, arr_loc);
    }

    //Getting Flight details (timings/seat_data)
    //error:giving whole flight but need flight data
    @GetMapping("/findFlight/{flight_id}")
    public Stream<Object> getFlight(@PathVariable("flight_id") int flight_id) {
        List<Flight> flight = frepo.findByFlight_Id(flight_id);

        return flight.stream().map(d -> d.getFlight());

    }

    // ADMIN SPECIFIC:
    // For Admin to add new Flight
    @PostMapping("/addFlights")
    public String addFlight(@RequestBody Flight flight) {
        frepo.save(flight);
        return "Added Flight:" + flight.getFlight();
    }

    @PostMapping("/addFlightData")
    public String addFlightData(@RequestBody FlightData flight) {
        fdrepo.save(flight);
        return "Added Flight: " + flight.getFlight_id();

    }

    // For Admin to update Flight
    @PutMapping("/updateFlightsData/{id}")
    public FlightData updateFlight(@RequestBody FlightData flight, @PathVariable("id") int flights_id) {
        flight.setFlight_id(flights_id);
        fdrepo.save(flight);
        return flight;

    }


}
