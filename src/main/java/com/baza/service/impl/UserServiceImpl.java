package com.baza.service.impl;

import com.baza.entity.Role;
import com.baza.entity.User;
import com.baza.repository.UserRepository;
import com.baza.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public List<User> findAllUsers() {
        return repository.findByRole(Role.USER);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setBalance(0);
        repository.save(user);
    }

}
