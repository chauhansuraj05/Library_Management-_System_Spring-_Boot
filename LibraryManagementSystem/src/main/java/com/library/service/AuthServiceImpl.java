package com.library.service;

import com.library.dto.*;
import com.library.entity.User;
import com.library.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repo;

    public AuthServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public String register(RegisterRequest r) {
        if (repo.existsByEmail(r.getEmail()))
            throw new IllegalArgumentException("Email already registered");

        User u = new User();
        u.setName(r.getName());
        u.setEmail(r.getEmail());
        u.setPassword(r.getPassword());
        repo.save(u);

        return "User registered successfully";
    }

    public String login(LoginRequest r) {
        User u = repo.findByEmail(r.getEmail())
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid email or password"));

        if (!u.getPassword().equals(r.getPassword()))
            throw new IllegalArgumentException("Invalid email or password");

        return "Login successful. User ID: " + u.getId();
    }
}
