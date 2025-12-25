package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user);
    User getUser(long id);
    User login(String email, String password);
}
