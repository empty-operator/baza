package com.baza.service;

import com.baza.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    void save(User user);

    void register(User user);
}
