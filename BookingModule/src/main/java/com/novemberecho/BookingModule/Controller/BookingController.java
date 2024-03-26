package com.novemberecho.BookingModule.Controller;

import com.novemberecho.BookingModule.Entity.Flight;
import com.novemberecho.BookingModule.Entity.Routes;
import com.novemberecho.BookingModule.Service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookingController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RoutesService routesService;


    @GetMapping("/home")
    public String homePage(Model model) {
        ResponseEntity<Routes[]> response = restTemplate.getForEntity(
                "http://AdminModule:8082/admin/fetch-all-routes",
                Routes[].class
        );

        Routes[] routesArray = response.getBody();
        List<Routes> routesList = Arrays.asList(routesArray);
        model.addAttribute("routes", routesList);
        return "homePage";
    }

    @GetMapping("/all-routes")
    public String allRoutes(Model model) {
        ResponseEntity<Flight[]> response = restTemplate.getForEntity(
                "http://AdminModule:8082/admin/fetch-all-flights",
                Flight[].class
        );

        Flight[] flightsArray = response.getBody();
        List<Flight> flightList = Arrays.asList(flightsArray);

        model.addAttribute("flights", flightList);

        return "AllRoutes";
    }

    /*@PostMapping("/search-results")
    public String searchResults(Model model) {
        model.addAttribute("Routes", new Routes());
    }*/

    @GetMapping("/search-results")
    public String searchResults(@RequestParam("route_from") String routeFrom, @RequestParam("route_to") String routeTo, Model model) {


        //String url = "http://AdminModule:8082/admin/search-flights?routeFrom=" + routeFrom +
        //"&routeTo=" + routeTo;
        String url = "http://AdminModule:8082/admin/search-flights/" + routeTo + "/" + routeFrom;
        ResponseEntity<Flight[]> response = restTemplate.getForEntity(url, Flight[].class);
        Flight[] flightsArray = response.getBody();
        List<Flight> flightList = Arrays.asList(flightsArray);
        if (flightList.isEmpty()) {
            return "accessDenied";
        } else {
            model.addAttribute("flights", flightList);
            return "searchPage";
        }
    }


    @GetMapping("/account")
    public String account() {
        return "redirect:http://localhost:9090/accounts/myAccount";
    }
}