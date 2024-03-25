package com.novemberecho.SearchModule.Controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class MainController {
    @GetMapping("/home")
    public String home() {
        return "X_homePage";
    }

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
}
