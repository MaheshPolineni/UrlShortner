package com.example.UrlShortner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlControllerWeb {
    @GetMapping("/")
    public String home() {
        return "url.html";
    }
}
