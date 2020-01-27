package com.denemelik.demo.service.impl;

import com.denemelik.demo.dao.UserDAO;
import com.denemelik.demo.model.User;
import com.denemelik.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptEncoder;

    @Transactional
    @Override
    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = new User();
        Boolean userExists = userDAO.existsByEmail(email);
        if (userExists != null && !userExists) {
            throw new UsernameNotFoundException("Invalid username or password.");
        } else {
            user = userDAO.findUserByEmail(email);
        }
        return user;
    }

    @Override
    public User save(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bCryptEncoder.encode(user.getPassword()));
        return userDAO.save(newUser);
    }
}
