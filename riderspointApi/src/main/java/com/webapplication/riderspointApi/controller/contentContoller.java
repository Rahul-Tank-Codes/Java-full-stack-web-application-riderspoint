package com.webapplication.riderspointApi.controller;

import com.webapplication.riderspointApi.entities.LoginRequest;
import com.webapplication.riderspointApi.entities.User;
import com.webapplication.riderspointApi.repository.userRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class contentContoller {

    @Autowired
    private userRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
       return "login";
    }

    @GetMapping("/req/registration")
    public String register(){
        return "register";
    }

    @GetMapping("/index")
    public String home(){

        return "index";
    }

    @GetMapping("/blog")
    public String userblog()
    {
        return "userblog";

    }

    @GetMapping("/group")
    public String usergroup()
    {
        return "usergroup";

    }

    @GetMapping("/about")
    public String aboutus(){

        return "about";
    }

    @GetMapping("/admin")
    public String adminpanel(){

        return "admin";
    }
}
