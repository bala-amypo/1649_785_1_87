package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {

        if (user == null) {
            throw new ValidationException("User cannot be null");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {

        if (email == null || email.isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }

        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new ValidationException("Invalid email or password");
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(password)) {
            throw new ValidationException("Invalid email or password");
        }

        return user;
    }

    @Override
    public User getUserById(Long id) {

        if (id == null) {
            throw new ValidationException("User ID cannot be null");
        }

        return userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User not found"));
    }
}
