package com.denemelik.demo.controller;

import com.denemelik.demo.config.TokenProvider;
import com.denemelik.demo.model.*;
import com.denemelik.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            return ResponseEntity.noContent().build();
        }

        if (false/*authentication*/) {
            return ResponseEntity.notFound().build();
        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setEmail(loginRequest.getEmail());

        TokenProvider tokenProvider = new TokenProvider();
        String tokenKey = tokenProvider.generateRandomToken(loginRequest.getEmail());
        loginResponse.setToken(tokenKey);

        return ResponseEntity.ok(loginResponse);
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        userService.save(user);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setEmail(registerRequest.getEmail());

     return ResponseEntity.ok(registerResponse);
    }
}
