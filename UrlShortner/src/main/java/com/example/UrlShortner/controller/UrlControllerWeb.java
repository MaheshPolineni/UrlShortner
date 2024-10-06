package com.example.UrlShortner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlControllerWeb {
    @GetMapping("/home")
    public String home() {
        return "url";
    }
    @GetMapping("/login") // Add this method to handle GET requests for login
    public String login() {
        return "login"; // Return the name of your login HTML template (e.g., login.html)
    }
}
