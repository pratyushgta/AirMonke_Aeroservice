package com.novemberecho.Authentication.Controller;


import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Repository.UserRepository;
import com.novemberecho.Authentication.Service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/view-accounts")
    public String admin_accounts() {
        return "view-accounts";
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


 /*@GetMapping("/home")
    public String display() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/homeX", String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return "redirect:/homeX";
        } else {
            return "accessDenied";
        }
    }*/