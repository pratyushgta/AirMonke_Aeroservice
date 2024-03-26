package com.novemberecho.Authentication.Controller;


import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Repository.UserRepository;
import com.novemberecho.Authentication.Service.CustomUserDetails;
import com.novemberecho.Authentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/accounts")
public class MainController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/home")
    public String home() {
        //return "redirect:http://localhost:9090/search/home";
        //return "homePage";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            //return restTemplate.getForObject("http://localhost:9090/admin/admin-home", Flight[].class);
            return "redirect:http://localhost:9090/admin/admin-home";
        } else {
            return "redirect:http://localhost:9090/book/home";
        }
    }

    @GetMapping("/all-routes")
    public String allRoutes() {
        return "redirect:http://localhost:9090/book/all-routes";

    }

    @GetMapping("/myAccount")
    public String myAccount(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            //return restTemplate.getForObject("http://localhost:9090/admin/admin-home", Flight[].class);
            return "loginPage";
        } else {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String email = loggedInUser.getName();
            model.addAttribute("user", userRepository.findByEmail(email));
            return "myAccount";
        }
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping("/get-user-details")
    public String response() {
        String name = "";
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if (loggedInUser == null) {
            name = null;
        } else {
            name = userRepository.findByEmail(loggedInUser.getName()).getFirstName();
        }
        return name;
    }
}