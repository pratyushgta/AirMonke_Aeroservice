package com.novemberecho.Authentication.Controller;

import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts/registration")
public class AuthController {
    @RequestMapping("/test")
    String display() {
        return "Register Hello World";
    }

    private UserService userService;

    public AuthController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registrationPage";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, HttpServletRequest request) throws ServletException {
        userService.save(registrationDto);
        //request.login(registrationDto.getEmail(), registrationDto.getPassword());
        return "redirect:/accounts/registration?success";
        //return "redirect:/";
    }

}
