package com.example.UrlShortner;

import com.example.UrlShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;
    @PostMapping("/saveUrl")
    public String save(@RequestParam String actualUrl) throws MalformedURLException {
        return urlService.save(actualUrl);
    }
    @GetMapping(value="/redirect")
    public RedirectView redirect(@RequestParam String shortenUrl){
        return urlService.redirect(shortenUrl);
    }
}
