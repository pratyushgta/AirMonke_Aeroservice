package com.novemberecho.Authentication.Controller;


import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


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
        return "redirect:http://localhost:9090/search/home";
        //return "homePage";
    }


    /*@GetMapping("/home")
    public String display() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/homeX", String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return "redirect:/homeX";
        } else {
            return "accessDenied";
        }
    }*/


    @GetMapping("/view-accounts")
    public String admin_accounts() {
        return "view-accounts";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    /*@GetMapping
    public String currentUser(@ModelAttribute("user") UserRegistrationDto userDto, BindingResult result, Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userRepository.findByEmail(email);
        String firstname = user.getFirstName();
        model.addAttribute("firstName", firstname);
        model.addAttribute("emailAddress", email);

        return "homePage"; //this is the name of my template
    }*/
}
