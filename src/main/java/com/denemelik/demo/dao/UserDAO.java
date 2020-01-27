package com.denemelik.demo.dao;

import com.denemelik.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
