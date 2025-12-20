package com.example.demo.service;
import com.example.demo.entity.User;
import java.util.*;
public interface UserService{
    User postData(User stu);
    List<User> getData();
    String deleteData(int id);
    User findData(int id);
    User updateData(int id,User s);
}