package com.example.UrlShortner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlControllerWeb {
    @GetMapping("/")
    public String home() {
        return "url";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
