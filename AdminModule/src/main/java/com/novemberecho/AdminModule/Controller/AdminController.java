package com.novemberecho.AdminModule.Controller;

import com.novemberecho.AdminModule.DTO.FlightDto;
import com.novemberecho.AdminModule.Entity.Flight;
import com.novemberecho.AdminModule.Entity.Routes;
import com.novemberecho.AdminModule.Service.FlightService;
import com.novemberecho.AdminModule.Service.RoutesService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RoutesService routesService;

    @Autowired
    FlightService flightService;

    /*@RequestMapping("/display")
    String display() {
        return "Admin Hello World";
    }*/

    @GetMapping("/admin-home")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/home")
    public String home() {
        return "redirect:http://localhost:9090/search/home";
    }

    /*
    @GetMapping
    public String currentUser(@ModelAttribute("user") Model model) {
        String firstName = restTemplate.getForObject("http://eureka-client2:8082/ms2", String.class);

        model.addAttribute("name", firstName);
        System.out.println(">>>>>>>>>>> NAME RETURNED: " + firstName);
        return "adminHome"; //this is the name of my template
    }*/

    /*@PostMapping(value = "/addFlights")
    public Flight addFlight(@RequestBody Flight flight) throws InterruptedException {
        restTemplate.postForObject("https://SearchModule:8081/Search/addFlights", flight, Flight.class);
        Thread.sleep(3000);
        return flight;
    }*/

    @GetMapping("/modifyRoutes")
    public String modifyRoutes(Model model) {
        model.addAttribute("Routes", routesService.getAllRoutes());
        return "adminModifyRoutes";
    }


    @GetMapping("/modifyRoutes/add")
    public String modifyRoutesAdd(Model model) {
        model.addAttribute("Routes", new Routes());
        return "adminModifyRoutesAdd";
    }

    //route
    @PostMapping("/modifyRoutes/add")
    public String postRoutesAdd(@ModelAttribute("Routes") Routes routes) {
        routesService.addRoute(routes);
        return "redirect:/admin/modifyRoutes";
    }

    //delete mapping not compatible here because we are working with forms which support get and post only
    //
    @GetMapping("/modifyRoutes/delete/{id}")
    public String modifyRoutesDelete(@PathVariable int id) {
        routesService.deleteRoutebyID(id);
        return "redirect:/admin/modifyRoutes";
    }

    @GetMapping("/modifyRoutes/update/{id}")
    public String modifyRoutesUpdate(@PathVariable int id, Model model) {
        Optional<Routes> route = routesService.getRoutesbyID(id);
        if (route.isPresent()) {
            model.addAttribute("Routes", route.get());
            return "adminModifyRoutesAdd";
        } else {
            return "accessDenied";
        }
    }

    //HANDLING FLIGHTS
    @GetMapping("/modifyFlight")
    public String modifyFlights(Model model) {
        model.addAttribute("Flight", flightService.getAllFlights());
        return "adminModifyFlight";
    }

    @GetMapping("/modifyFlight/add")
    public String modifyFlightAdd(Model model) {
        model.addAttribute("FlightDTO", new FlightDto());
        model.addAttribute("Routes", routesService.getAllRoutes());
        return "adminModifyFlightAdd";
    }

    @PostMapping("/modifyFlight/add")
    public String postFlightAdd(@ModelAttribute("FlightDTO") FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlight_id(flightDto.getFlight_id());
        flight.setFlight_num(flightDto.getFlight_num());
        // flight.setRoutes(routesService.getRoutesbyID(flight.getRoutes().getRoutes_id()).get());
        flight.setArrival_routes(routesService.getAllRoutes().get(0));
        flight.setDeparture_routes(routesService.getAllRoutes().get(1));
        List<Routes> routes = routesService.getAllRoutes();
        flight.setDeparture_city(routes.get(0).getCity());
        flight.setDeparture_time(flightDto.getDeparture_time());
        flight.setArrival_city(routes.get(1).getCity());
        flight.setArrival_time(flightDto.getArrival_time());

        flightService.addFlight(flight);

        return "redirect:/admin/modifyFlight";
    }

    @GetMapping("/modifyFlight/delete/{id}")
    public String modifyFlightDelete(@PathVariable int id) {
        flightService.deleteFlightbyID(id);
        return "redirect:/admin/modifyFlight";
    }

    @GetMapping("/modifyFlight/update/{id}")
    public String modifyFlightUpdate(@PathVariable int id, Model model) {
        Flight flight = flightService.getFlightbyID(id).get();
        FlightDto flightDto = new FlightDto();
        flightDto.setFlight_id(flight.getFlight_id());
        flightDto.setFlight_num(flight.getFlight_num());
        flightDto.setRoutes_id_arrival(flight.getArrival_routes().getRoutes_id());
        flightDto.setRoutes_id_departure(flight.getDeparture_routes().getRoutes_id());
        flightDto.setDeparture_city(flight.getDeparture_city());
        flightDto.setArrival_city(flight.getArrival_city());
        flightDto.setDeparture_time(flight.getDeparture_time());
        flightDto.setArrival_time(flight.getArrival_time());

        model.addAttribute("FlightDTO", new FlightDto());
        model.addAttribute("Routes", routesService.getAllRoutes());

        return "adminModifyFlightAdd";
    }
}










    /*@PostMapping("/modifyRoutes/add")
    public String postRoutesAdd(@ModelAttribute("Routes") Routes routes) {
        routesService.addRoute(routes);
        return "redirect:/admin/modifyRoutes";
    }*/
