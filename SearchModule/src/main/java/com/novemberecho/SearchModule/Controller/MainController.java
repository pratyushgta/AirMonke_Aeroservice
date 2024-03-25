package com.novemberecho.SearchModule.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class MainController {
    @GetMapping("/X_home")
    public String home() {
        return "X_homePage";
    }
}
