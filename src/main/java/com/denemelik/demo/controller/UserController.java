package com.denemelik.demo.controller;

import com.denemelik.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("Ozgur");
        return user;
    }
}