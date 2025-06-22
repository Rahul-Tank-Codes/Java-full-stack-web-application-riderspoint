package com.webapplication.riderspointApi.controller;

import com.webapplication.riderspointApi.entities.User;
import com.webapplication.riderspointApi.repository.userRepository;
import com.webapplication.riderspointApi.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    private userRepository userRepository;




    @Autowired
    private PasswordEncoder passwordEncoder;




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Username or password cannot be empty");
        }

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
            return ResponseEntity.ok(Map.of("message", "Login Successful"));
        }

        else {
                return ResponseEntity.status(401).body("Invalid username or password");
            }
    }


}
