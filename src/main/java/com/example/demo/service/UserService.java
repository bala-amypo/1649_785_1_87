package com.example.demo.service;
import com.example.demo.entity.User;
import java.util.*;
public interface UserService{
    User registerUser(User stu);
    List<User> getAllUser();
    User getUser(Long id);
    User getByEmail(String email);
}