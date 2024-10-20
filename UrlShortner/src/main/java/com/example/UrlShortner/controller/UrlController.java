package com.example.UrlShortner.controller;

import com.example.UrlShortner.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;
    @PostMapping("/saveUrl")
    public ResponseEntity<Map<String,String>> save(@RequestParam String actualUrl) throws MalformedURLException {
        String shortUrl=urlService.save(actualUrl);
        Map<String,String> url=new HashMap<>();
        url.put("shortUrl",shortUrl);
        return ResponseEntity.ok(url);
    }
    @GetMapping(value="/r")
    public RedirectView redirect(@RequestParam String s){
        return urlService.redirect(s);
    }
    @GetMapping(value="/hello")
    public String hello(HttpServletRequest request){
        return "Hello";
    }
}
