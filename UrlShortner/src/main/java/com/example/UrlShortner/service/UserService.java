package com.example.UrlShortner.service;

import com.example.UrlShortner.entity.UserEntity;
import com.example.UrlShortner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserEntity userEntity){
        List<UserEntity> usersList = userRepository.findAll();
        for(UserEntity user : usersList) {
            if(userEntity.getEmail().equals(user.getEmail())) {
                return String.format("User with mail %s already Exists", userEntity.getEmail());
            }
        }
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return String.format("User %s with mail %s is created successfully", userEntity.getUsername(), userEntity.getEmail());
    }
    public String login(String email,String password){
       UserEntity user=userRepository.findByEmail(email);
        if (user.getEmail().equals(email) && passwordEncoder.matches(password,user.getPassword()))
            return "success";
        return "Invalid Credentials";
    }
}
