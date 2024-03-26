package com.novemberecho.BookingModule.Controller;

import com.novemberecho.BookingModule.Entity.Flight;
import com.novemberecho.BookingModule.Service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/modifyFlight/delete/{arrival}/{departure}")
    public String searchFlight(@PathVariable String arrival, @PathVariable String departure) {
        String flightList= restTemplate.getForObject("http://AdminModule:8082/admin/fetch/{arrival}/{departure}", String.class);
        System.out.println(flightList);
        return "redirect:/admin/modifyFlight";
    }


}










    /*@PostMapping("/modifyRoutes/add")
    public String postRoutesAdd(@ModelAttribute("Routes") Routes routes) {
        routesService.addRoute(routes);
        return "redirect:/admin/modifyRoutes";
    }*/
