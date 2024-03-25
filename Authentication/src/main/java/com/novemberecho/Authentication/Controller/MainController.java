package com.novemberecho.Authentication.Controller;


import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/accounts")
public class MainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/home")
    public String home() {
        return "homePage";
    }

    @GetMapping("/view-accounts")
    public String admin_accounts() {
        return "view-accounts";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping
    public String currentUser(@ModelAttribute("user") UserRegistrationDto userDto, BindingResult result, Model model) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();

        User user = userRepository.findByEmail(email);
        String firstname = user.getFirstName();
        model.addAttribute("firstName", firstname);
        model.addAttribute("emailAddress", email);

        return "homePage"; //this is the name of my template
    }
}
