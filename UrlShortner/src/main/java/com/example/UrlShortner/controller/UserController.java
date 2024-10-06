package com.example.UrlShortner.controller;

import com.example.UrlShortner.entity.UserEntity;
import com.example.UrlShortner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> saveUser(@RequestBody UserEntity userEntity){
        String result= userService.saveUser(userEntity);
        Map<String,String> response=new HashMap<>();
        if(result.equals(String.format("User with mail %s already Exists", userEntity.getEmail()))){
            response.put("success","false");
            response.put("message",result);
        }
        else{
            response.put("success","true");
            response.put("message",result);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return "Login successful";
//        } catch (BadCredentialsException e) {
//            return "Invalid credentials";
//        }
//    }
    @PostMapping("/login-user")
    public ResponseEntity<Map<String, String>> login(@RequestParam String email, @RequestParam String password) {
        String result = userService.login(email, password);
        Map<String, String> response = new HashMap<>();
        if ("success".equals(result)) {
            response.put("success", "true");
            response.put("redirect", "/home");
        } else {
            response.put("success", "false");
            response.put("message", result);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
