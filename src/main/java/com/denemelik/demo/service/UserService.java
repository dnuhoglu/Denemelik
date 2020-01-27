package com.denemelik.demo.service;

import com.denemelik.demo.model.User;

public interface UserService {
    User save(User user);
    User loadUserByEmail(String email);
}
