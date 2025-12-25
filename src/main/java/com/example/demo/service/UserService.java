package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    User login(String email, String password);

    User getUser(Long id);

    List<User> getAllUsers();
}
