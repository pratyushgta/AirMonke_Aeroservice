package com.novemberecho.BookingModule.Controller;

import com.novemberecho.BookingModule.Entity.Flight;
import com.novemberecho.BookingModule.Service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public String homePage() {
        return "homePage";
    }

    /*@GetMapping("/fetch")
    public String searchFlight() {
        String flightList = restTemplate.getForObject("http://AdminModule:8082/admin/fetch/Delhi}/Mumbai", String.class);
        System.out.println(flightList);
        return "redirect:/admin/modifyFlight";
    }*/


}










    /*@PostMapping("/modifyRoutes/add")
    public String postRoutesAdd(@ModelAttribute("Routes") Routes routes) {
        routesService.addRoute(routes);
        return "redirect:/admin/modifyRoutes";
    }*/
